package com.maulnad.moviecatalogue.di

import android.content.Context
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.LocalDataSource
import com.maulnad.moviecatalogue.data.source.local.room.CatalogueDatabase
import com.maulnad.moviecatalogue.data.source.remote.RemoteDataSource
import com.maulnad.moviecatalogue.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}