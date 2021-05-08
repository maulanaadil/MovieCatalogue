package com.maulnad.moviecatalogue.ui.home.content.movies

import androidx.lifecycle.ViewModel
import com.maulnad.moviecatalogue.model.DataEntity
import com.maulnad.moviecatalogue.utils.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies(): List<DataEntity> = DataDummy.generateDummyMovies()
}