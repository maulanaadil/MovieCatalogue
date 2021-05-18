package com.maulnad.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.databinding.ActivityDetailPageBinding
import com.maulnad.moviecatalogue.databinding.ContentDetailPageBinding
import com.maulnad.moviecatalogue.data.model.DataEntity
import com.maulnad.moviecatalogue.utils.Helper
import com.maulnad.moviecatalogue.viewmodel.ViewModelFactory

class DetailPageActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var detailContentBinding: ContentDetailPageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailPageBinding = ActivityDetailPageBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailPageBinding.detailContent

        setContentView(activityDetailPageBinding.root)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_detail)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this@DetailPageActivity, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE)
            val tvShowId = extras.getInt(EXTRA_TV)


            if (movieId != null) {
                activityDetailPageBinding.progressBar.visibility = View.VISIBLE
                activityDetailPageBinding.nestedScrollView.visibility = View.INVISIBLE

                viewModel.getDetailMovie(movieId).observe(this, { movies ->
                    activityDetailPageBinding.progressBar.visibility = View.GONE
                    activityDetailPageBinding.nestedScrollView.visibility = View.VISIBLE

                    populateMovies(movies)
                })
            }


            if (tvShowId != null) {
                activityDetailPageBinding.progressBar.visibility = View.VISIBLE
                activityDetailPageBinding.nestedScrollView.visibility = View.INVISIBLE

                viewModel.getDetailTvShow(tvShowId).observe(this, { tvShows ->
                    activityDetailPageBinding.progressBar.visibility = View.GONE
                    activityDetailPageBinding.nestedScrollView.visibility = View.VISIBLE

                    populateMovies(tvShows)
                })
            }


        }
    }

    private fun populateMovies(dataEntity: DataEntity) {
        detailContentBinding.tvTitle.text = dataEntity.title
        detailContentBinding.tvDesc.text = dataEntity.description

        Glide.with(this)
            .load(Helper.IMAGE_URL_TMDD_ENDPOINT + Helper.IMAGE_URL_SIZE_ENDPOINT + dataEntity.backDrop)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detailContentBinding.ivPoster)

        Glide.with(this)
            .load(Helper.IMAGE_URL_TMDD_ENDPOINT + Helper.IMAGE_URL_SIZE_ENDPOINT + dataEntity.poster)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
            .into(detailContentBinding.ivPoster2)
    }
}

