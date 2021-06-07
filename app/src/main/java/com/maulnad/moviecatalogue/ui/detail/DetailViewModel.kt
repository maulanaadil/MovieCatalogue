package com.maulnad.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.vo.Resource

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    val movieId = MutableLiveData<Int>()
    val tvShowId = MutableLiveData<Int>()

    fun setSelectedMovie(movieId: Int) {
        this.movieId.value = movieId
    }

    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId.value = tvShowId
    }

    var detailMovie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) {
        catalogueRepository.getDetailMovie(it)
    }

    var detailTvShow: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId) {
        catalogueRepository.getDetailTvShow(it)
    }

    fun setFavouriteMovie() {
        val movieResource = detailMovie.value
        if (movieResource?.data != null) {
            val newState = !movieResource.data.favourite
            catalogueRepository.setFavouriteMovie(movieResource.data, newState)
        }
    }

    fun setFavouriteTvShow() {
        val tvShowResource = detailTvShow.value
        if (tvShowResource?.data != null) {
            val newState = !tvShowResource.data.favourite
            catalogueRepository.setFavouriteTvShow(tvShowResource.data, newState)
        }
    }
}