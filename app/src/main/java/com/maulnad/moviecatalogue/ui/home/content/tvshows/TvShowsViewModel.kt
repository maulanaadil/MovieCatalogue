package com.maulnad.moviecatalogue.ui.home.content.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.vo.Resource

class TvShowsViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = catalogueRepository.getAllTvShow()
}