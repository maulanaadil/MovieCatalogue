package com.maulnad.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.databinding.ActivityDetailPageBinding
import com.maulnad.moviecatalogue.databinding.ContentDetailPageBinding
import com.maulnad.moviecatalogue.utils.Helper
import com.maulnad.moviecatalogue.viewmodel.ViewModelFactory
import com.maulnad.moviecatalogue.vo.Status

class DetailPageActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var activityDetailPageBinding: ActivityDetailPageBinding

    private lateinit var detailContentBinding: ContentDetailPageBinding
    private lateinit var viewModel: DetailViewModel

    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailPageBinding = ActivityDetailPageBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailPageBinding.detailContent

        setContentView(activityDetailPageBinding.root)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val factory = ViewModelFactory.getInstance(applicationContext)
        viewModel = ViewModelProvider(this@DetailPageActivity, factory)[DetailViewModel::class.java]

//        val extras = intent.extras
//        if (extras != null) {
        val movieId = intent.getIntExtra(EXTRA_MOVIE, 0)
        val tvShowId = intent.getIntExtra(EXTRA_TV, 0)

        activityDetailPageBinding.progressBar.visibility = View.VISIBLE
        activityDetailPageBinding.nestedScrollView.visibility = View.INVISIBLE

        if (intent.hasExtra(EXTRA_MOVIE)) {
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                viewModel.detailMovie.observe(this, {
                    activityDetailPageBinding.progressBar.visibility = View.GONE
                    activityDetailPageBinding.nestedScrollView.visibility = View.VISIBLE
                    populateMovies(it)
                    setFavouriteState(it.favourite)
                })
            }
        } else
            if (intent.hasExtra(EXTRA_TV)) {
                if (tvShowId != null) {
                    viewModel.setSelectedTvShow(tvShowId)
                    viewModel.detailTvShow.observe(this, {
                        activityDetailPageBinding.progressBar.visibility = View.GONE
                        activityDetailPageBinding.nestedScrollView.visibility = View.VISIBLE
                        populateTvShow(it)
                        setFavouriteState(it.favourite)
                    })
                }
            }
//        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        if (intent.hasExtra(EXTRA_MOVIE)) {
            viewModel.detailMovie.observe(this, {
                activityDetailPageBinding.progressBar.visibility = View.GONE
                activityDetailPageBinding.nestedScrollView.visibility = View.VISIBLE
                viewModel.setFavouriteMovie()
            })
        } else
            if (intent.hasExtra(EXTRA_TV)) {
                viewModel.detailTvShow.observe(this, {
                    activityDetailPageBinding.progressBar.visibility = View.GONE
                    activityDetailPageBinding.nestedScrollView.visibility = View.VISIBLE
                    viewModel.setFavouriteTvShow()
                })
            }
        return true
    }

    private fun setFavouriteState(state: Boolean?) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favourite)
        if (state!!) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favourited)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favourite)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (intent.hasExtra(EXTRA_MOVIE)) {
            if (item.itemId == R.id.action_favourite) {
                viewModel.setFavouriteMovie()
            }
        } else
            if (intent.hasExtra(EXTRA_TV)) {
                if (item.itemId == R.id.action_favourite) {
                    viewModel.setFavouriteTvShow()
                }
            }
        return super.onOptionsItemSelected(item)
    }


    private fun populateMovies(movieEntity: MovieEntity) {
        detailContentBinding.tvTitle.text = movieEntity.title
        detailContentBinding.tvDesc.text = movieEntity.description

        Glide.with(this)
            .load(Helper.IMAGE_URL_TMDD_ENDPOINT + Helper.IMAGE_URL_SIZE_ENDPOINT + movieEntity.backDrop)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
            )
            .into(detailContentBinding.ivPoster)

        Glide.with(this)
            .load(Helper.IMAGE_URL_TMDD_ENDPOINT + Helper.IMAGE_URL_SIZE_ENDPOINT + movieEntity.poster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
            )
            .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
            .into(detailContentBinding.ivPoster2)
    }

    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        detailContentBinding.tvTitle.text = tvShowEntity.title
        detailContentBinding.tvDesc.text = tvShowEntity.description

        Glide.with(this)
            .load(Helper.IMAGE_URL_TMDD_ENDPOINT + Helper.IMAGE_URL_SIZE_ENDPOINT + tvShowEntity.backDrop)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
            )
            .into(detailContentBinding.ivPoster)

        Glide.with(this)
            .load(Helper.IMAGE_URL_TMDD_ENDPOINT + Helper.IMAGE_URL_SIZE_ENDPOINT + tvShowEntity.poster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
            )
            .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
            .into(detailContentBinding.ivPoster2)

    }

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return true
    }

}







