package com.maulnad.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.CatalogueDataSource
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.data.source.remote.RemoteDataSource
import com.maulnad.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.maulnad.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource) :
    CatalogueDataSource {

    override fun getAllMovie(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onAllMovieReceived(moviesResponse: List<MovieDetailResponse>?) {
                    val movieList = ArrayList<MovieEntity>()
                    if (moviesResponse != null) {
                        for (response in moviesResponse) {
                            val movie = MovieEntity(
                                response.id,
                                response.title,
                                response.overview,
                                response.posterPath,
                                response.backgroundPath
                            )
                            movieList.add(movie)
                        }
                    }
                    movieResults.postValue(movieList)
                }
            })
        }
        return movieResults
    }

    override fun getAllTvShow(): LiveData<List<TvShowEntity>> {
        val tvShowResult = MutableLiveData<List<TvShowEntity>>()
        CoroutineScope(IO).launch {

            remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowCallback {
                override fun onAllTvShowReceived(tvShowsResponse: List<TvShowDetailResponse>?) {
                    val tvShowList = ArrayList<TvShowEntity>()
                    if (tvShowsResponse != null) {
                        for (response in tvShowsResponse) {
                            val tvShow = TvShowEntity(
                                response.id,
                                response.name,
                                response.overview,
                                response.posterPath,
                                response.backdropPath
                            )
                            tvShowList.add(tvShow)
                        }
                    }
                    tvShowResult.postValue(tvShowList)
                }
            })
        }
        return tvShowResult
    }

    override fun getDetailMovie(movieId: Int): LiveData<MovieEntity> {
        val movieResults = MutableLiveData<MovieEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getDetailMovies(object : RemoteDataSource.LoadMoviesDetailCallback {
                override fun onMovieDetailReceived(moviesResponse: MovieDetailResponse?) {
                    val movie =
                        moviesResponse?.let {
                            MovieEntity(
                                it.id,
                                it.title,
                                it.overview,
                                it.posterPath,
                                it.backgroundPath
                            )
                        }
                    movieResults.postValue(movie)
                }
            }, movieId)
        }
        return movieResults
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<TvShowEntity> {
        val tvShowResult = MutableLiveData<TvShowEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadTvShowsDetailCallback {
                override fun onTvShowDetailReceived(tvShowsResponse: TvShowDetailResponse?) {
                    val tvShow = tvShowsResponse?.let {
                        TvShowEntity(
                            it.id,
                            it.name,
                            it.overview,
                            it.posterPath,
                            it.backdropPath
                        )
                    }
                    tvShowResult.postValue(tvShow)
                }

            }, tvShowId)
        }
        return tvShowResult
    }
}