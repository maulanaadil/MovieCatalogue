package com.maulnad.moviecatalogue.ui.home.content.favourite.content.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity


class FavouriteMoviesViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getFavouriteMovies(): LiveData<PagedList<MovieEntity>> =
        catalogueRepository.getListFavouriteMovie()


    fun setFavourite(movieEntity: MovieEntity) {
        val newState = !movieEntity.favourite
        catalogueRepository.setFavouriteMovie(movieEntity, newState)

    }
}