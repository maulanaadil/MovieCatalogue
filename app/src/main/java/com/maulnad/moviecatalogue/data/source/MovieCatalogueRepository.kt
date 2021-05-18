package com.maulnad.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maulnad.moviecatalogue.data.model.DataEntity
import com.maulnad.moviecatalogue.data.source.remote.*
import com.maulnad.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.maulnad.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovie(): LiveData<List<DataEntity>> {
        val movieResults = MutableLiveData<List<DataEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getAllMovies( object : RemoteDataSource.LoadMoviesCallback {
                override fun onAllMovieReceived(moviesResponse: List<MovieDetailResponse>?) {
                    val movieList = ArrayList<DataEntity>()
                    if (moviesResponse != null) {
                        for (response in moviesResponse) {
                            val movie = DataEntity(
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

    override fun getTvShow(): LiveData<List<DataEntity>> {
        val tvShowResult = MutableLiveData<List<DataEntity>>()
        CoroutineScope(IO).launch {

            remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowCallback {
                override fun onAllTvShowReceived(tvShowsResponse: List<TvShowDetailResponse>?) {
                    val tvShowList = ArrayList<DataEntity>()
                    if (tvShowsResponse != null) {
                        for (response in tvShowsResponse) {
                            val tvShow = DataEntity(
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

    override fun getDetailMovie(movieId: Int): LiveData<DataEntity> {
        val movieResults = MutableLiveData<DataEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getDetailMovies(object : RemoteDataSource.LoadMoviesDetailCallback {
                override fun onMovieDetailReceived(moviesResponse: MovieDetailResponse?) {
                    val movie = moviesResponse?.let {
                        DataEntity(
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

    override fun getDetailTvShow(tvShowId: Int): LiveData<DataEntity> {
        val tvShowResult = MutableLiveData<DataEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadTvShowsDetailCallback {
                override fun onTvShowDetailReceived(tvShowsResponse: TvShowDetailResponse?) {
                    val tvShow = tvShowsResponse?.let {
                        DataEntity(
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