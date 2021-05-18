package com.maulnad.moviecatalogue.ui.home.content.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.maulnad.moviecatalogue.data.model.DataEntity
import com.maulnad.moviecatalogue.data.source.MovieCatalogueRepository

class MoviesViewModel(private val catalogueRepository: MovieCatalogueRepository) : ViewModel() {
    fun getMovies(): LiveData<List<DataEntity>> = catalogueRepository.getAllMovie()
}