package com.maulnad.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao). apply {
                INSTANCE = this
            }
    }

    // movies
    fun getListMovies(): DataSource.Factory<Int, MovieEntity> = mCatalogueDao.getListMovies()

    fun getListFavouriteMovies(): DataSource.Factory<Int, MovieEntity> =
        mCatalogueDao.getListFavouriteMovie()

    fun getDetailMovieById(movieId: Int): LiveData<MovieEntity> =
        mCatalogueDao.getDetailMovieById(movieId)

    fun insertMovie(movies: List<MovieEntity>) = mCatalogueDao.insertMovies(movies)

    fun updateFavMovie(movie: MovieEntity, newState: Boolean) {
        movie.favourite = newState
        mCatalogueDao.updateMovie(movie)
    }

    // tvShows
    fun getListTvShows(): DataSource.Factory<Int, TvShowEntity> = mCatalogueDao.getListTvShows()

    fun getListFavouriteTvShows(): DataSource.Factory<Int, TvShowEntity> =
        mCatalogueDao.getListFavouriteTvShow()

    fun getDetailTvShowById(tvShowId: Int): LiveData<TvShowEntity> =
        mCatalogueDao.getDetailTvShowById(tvShowId)

    fun insertTvShow(tvShow: List<TvShowEntity>) = mCatalogueDao.insertTvShows(tvShow)

    fun updateFavTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.favourite = newState
        mCatalogueDao.updateTvShow(tvShow)
    }

}