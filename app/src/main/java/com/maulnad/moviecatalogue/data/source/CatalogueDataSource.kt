package com.maulnad.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.vo.Resource

interface CatalogueDataSource {
    //movies
    fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovie(movieId: Int): LiveData<MovieEntity>

    fun getListFavouriteMovie(): LiveData<PagedList<MovieEntity>>

    fun setFavouriteMovie(movie: MovieEntity, newState: Boolean)

    //tvShows
    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailTvShow(tvShowId: Int): LiveData<TvShowEntity>

    fun getListFavouriteTvShow(): LiveData<PagedList<TvShowEntity>>

    fun setFavouriteTvShow(tvShow: TvShowEntity, newState: Boolean)


}