package com.maulnad.moviecatalogue.ui.home.content.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.maulnad.moviecatalogue.data.model.DataEntity
import com.maulnad.moviecatalogue.data.source.MovieCatalogueRepository

class TvShowsViewModel(private val catalogueRepository: MovieCatalogueRepository) : ViewModel() {
    fun getTvShows(): LiveData<List<DataEntity>> = catalogueRepository.getTvShow()
}