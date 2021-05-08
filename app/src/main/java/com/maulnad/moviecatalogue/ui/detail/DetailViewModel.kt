package com.maulnad.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.maulnad.moviecatalogue.model.DataEntity
import com.maulnad.moviecatalogue.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setMovieId(movieId: String) {
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getDetailMovie(): DataEntity {
        lateinit var movie: DataEntity
        val movieEntities = DataDummy.generateDummyMovies()
        for (movieEntity in movieEntities) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getDetailTvShow(): DataEntity {
        lateinit var tvShow: DataEntity
        val tvShowEntities = DataDummy.generateDummyTvShows()
        for (tvShowEntity in tvShowEntities) {
            if (tvShowEntity.movieId == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }
}