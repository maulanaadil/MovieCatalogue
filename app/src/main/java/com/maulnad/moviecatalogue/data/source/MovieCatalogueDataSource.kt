package com.maulnad.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.maulnad.moviecatalogue.data.model.DataEntity

interface MovieCatalogueDataSource {
    fun getAllMovie(): LiveData<List<DataEntity>>

    fun getTvShow(): LiveData<List<DataEntity>>

    fun getDetailMovie(movieId: Int): LiveData<DataEntity>

    fun getDetailTvShow(tvShowId: Int): LiveData<DataEntity>
}