package com.maulnad.moviecatalogue.ui.home.content.favourite.content.tvhows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity

class FavouriteTvShowsViewModel(private val catalogueRepository: CatalogueRepository) :
    ViewModel() {
    fun getFavouriteTvShows(): LiveData<PagedList<TvShowEntity>> =
        catalogueRepository.getListFavouriteTvShow()

    fun setFavourite(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.favourite
        catalogueRepository.setFavouriteTvShow(tvShowEntity, newState)
    }
}