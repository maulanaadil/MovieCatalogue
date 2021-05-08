package com.maulnad.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.databinding.ActivityDetailPageBinding
import com.maulnad.moviecatalogue.databinding.ContentDetailPageBinding
import com.maulnad.moviecatalogue.model.DataEntity
import com.maulnad.moviecatalogue.utils.DataDummy

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

        val viewModel = ViewModelProvider(
            this@DetailPageActivity,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvShowId = extras.getString(EXTRA_TV)


            if (movieId != null) {
                viewModel.setMovieId(movieId)
                populateMovies(viewModel.getDetailMovie() as DataEntity)
                for (movie in DataDummy.generateDummyMovies()) {
                    if (movie.movieId == movieId) {
                        populateMovies(movie)
                    }
                }
            }


            if (tvShowId != null) {
                viewModel.setTvShowId(tvShowId)
                populateMovies(viewModel.getDetailTvShow() as DataEntity)
                for (tvShow in DataDummy.generateDummyTvShows()) {
                    if (tvShow.movieId == tvShowId) {
                        populateMovies(tvShow)
                    }
                }
            }


        }
    }

    private fun populateMovies(dataEntity: DataEntity) {
        detailContentBinding.tvTitle.text = dataEntity.title
        detailContentBinding.tvDesc.text = dataEntity.description
        detailContentBinding.tvGenre.text = dataEntity.genre
        detailContentBinding.tvRelease.text = dataEntity.releaseDate

        Glide.with(this)
            .load(dataEntity.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detailContentBinding.ivPoster)

        Glide.with(this)
            .load(dataEntity.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
            .into(detailContentBinding.ivPoster2)
    }
}

