package com.maulnad.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.di.Injection
import com.maulnad.moviecatalogue.ui.detail.DetailViewModel
import com.maulnad.moviecatalogue.ui.home.content.favourite.content.movies.FavouriteMoviesViewModel
import com.maulnad.moviecatalogue.ui.home.content.favourite.content.tvhows.FavouriteTvShowsViewModel
import com.maulnad.moviecatalogue.ui.home.content.movies.MoviesViewModel
import com.maulnad.moviecatalogue.ui.home.content.tvshows.TvShowsViewModel

class ViewModelFactory private constructor(private val mMovieCatalogueRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideRepository(context))
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                return TvShowsViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(FavouriteMoviesViewModel::class.java) -> {
                return FavouriteMoviesViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(FavouriteTvShowsViewModel::class.java) -> {
                return FavouriteTvShowsViewModel(mMovieCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}