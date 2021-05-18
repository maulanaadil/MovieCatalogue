package com.maulnad.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.maulnad.moviecatalogue.data.model.DataEntity
import com.maulnad.moviecatalogue.data.source.MovieCatalogueRepository
import kotlin.properties.Delegates

class DetailViewModel(private val catalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private var movieId by Delegates.notNull<Int>()
    private var tvShowId by Delegates.notNull<Int>()


    fun selectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun selectedTvShow(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getDetailMovie(movieId: Int): LiveData<DataEntity> =
        catalogueRepository.getDetailMovie(movieId)

    fun getDetailTvShow(tvShowId: Int): LiveData<DataEntity> =
        catalogueRepository.getDetailTvShow(tvShowId)
}