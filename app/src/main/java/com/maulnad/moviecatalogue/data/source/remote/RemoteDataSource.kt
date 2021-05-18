package com.maulnad.moviecatalogue.data.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.maulnad.moviecatalogue.BuildConfig
import com.maulnad.moviecatalogue.data.source.remote.api.ApiConfig
import com.maulnad.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.maulnad.moviecatalogue.data.source.remote.response.MovieResponse
import com.maulnad.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import com.maulnad.moviecatalogue.data.source.remote.response.TvShowResponse
import com.maulnad.moviecatalogue.utils.EspressoIdlingResources
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource().apply { instance = this }
        }
    }

    fun getAllMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResources.increment()
        val client = ApiConfig.getApiService().getDiscoverMovies(BuildConfig.TMDBApi)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get All Movie Success")
                    callback.onAllMovieReceived(response.body()?.results)
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "Get Movies onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }
        })
    }

    fun getDetailMovies(callback: LoadMoviesDetailCallback, movieId: Int) {
        EspressoIdlingResources.increment()
        val client = ApiConfig.getApiService().getDetailMovie(movieId, BuildConfig.TMDBApi)
        client.enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Detail Success")
                    callback.onMovieDetailReceived(response.body())
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e(TAG, "Get Movies Detail onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }

        })
    }

    fun getAllTvShows(callback: LoadTvShowCallback) {
        EspressoIdlingResources.increment()
        val client = ApiConfig.getApiService().getDiscoverTvShow(BuildConfig.TMDBApi)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get All TvShows Success")
                    callback.onAllTvShowReceived(response.body()?.results)
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, "Get TvShows onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }

        })
    }

    fun getDetailTvShow(callback: LoadTvShowsDetailCallback, tvShowId: Int) {
        EspressoIdlingResources.increment()
        val client = ApiConfig.getApiService().getDetailTvShow(tvShowId, BuildConfig.TMDBApi)
        client.enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get Detail TvShow Success")
                    callback.onTvShowDetailReceived(response.body())
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG, "onFailure : ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.e(TAG, "Get TvShows Detail onFailure: ${t.message.toString()} ")
                EspressoIdlingResources.decrement()
            }

        })
    }

    interface LoadTvShowsDetailCallback {
        fun onTvShowDetailReceived(tvShowsResponse: TvShowDetailResponse?)
    }

    interface LoadMoviesDetailCallback {
        fun onMovieDetailReceived(moviesResponse: MovieDetailResponse?)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowsResponse: List<TvShowDetailResponse>?)
    }

    interface LoadMoviesCallback {
        fun onAllMovieReceived(moviesResponse: List<MovieDetailResponse>?)
    }
}


