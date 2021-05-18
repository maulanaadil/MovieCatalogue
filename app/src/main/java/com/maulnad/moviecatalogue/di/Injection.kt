package com.maulnad.moviecatalogue.di

import com.maulnad.moviecatalogue.data.source.MovieCatalogueRepository
import com.maulnad.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): MovieCatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieCatalogueRepository.getInstance(remoteDataSource)
    }
}