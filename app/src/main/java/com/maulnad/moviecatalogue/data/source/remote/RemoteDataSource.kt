package com.maulnad.moviecatalogue.data.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maulnad.moviecatalogue.BuildConfig
import com.maulnad.moviecatalogue.data.source.remote.api.ApiConfig
import com.maulnad.moviecatalogue.data.source.remote.response.*
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

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        val client = ApiConfig.getApiService().getDiscoverMovies(BuildConfig.TMDBApi)
        client.enqueue(object : Callback<ListResponse<MovieResponse>> {
            override fun onResponse(
                call: Call<ListResponse<MovieResponse>>,
                response: Response<ListResponse<MovieResponse>>
            ) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get All Movie Success")
                    resultMovie.value = ApiResponse.success(response.body()?.results as List<MovieResponse>)
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<ListResponse<MovieResponse>>, t: Throwable) {
                Log.e(TAG, "Get Movies onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }
        })
        return resultMovie
    }

    fun getDetailMovies(movieId: Int): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResources.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<MovieResponse>>()
        val client = ApiConfig.getApiService().getDetailMovie(movieId, BuildConfig.TMDBApi)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                if (response.isSuccessful) {
                    resultDetailMovie.value = ApiResponse.success(response.body() as MovieResponse)
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "Get Movies Detail onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }
        })
        return resultDetailMovie
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResources.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        val client = ApiConfig.getApiService().getDiscoverTvShow(BuildConfig.TMDBApi)
        client.enqueue(object : Callback<ListResponse<TvShowResponse>> {

            override fun onResponse(
                call: Call<ListResponse<TvShowResponse>>,
                response: Response<ListResponse<TvShowResponse>>
            ) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get All TvShows Success")
                    resultTvShow.value = ApiResponse.success(response.body()?.results as List<TvShowResponse>)
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<ListResponse<TvShowResponse>>, t: Throwable) {
                Log.e(TAG, "Get TvShows onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }
        })
        return resultTvShow
    }

    fun getDetailTvShow(tvShowId: Int): LiveData<ApiResponse<TvShowResponse>> {
        EspressoIdlingResources.increment()
        val resultDetailTvShow = MutableLiveData<ApiResponse<TvShowResponse>>()
        val client = ApiConfig.getApiService().getDetailTvShow(tvShowId, BuildConfig.TMDBApi)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    resultDetailTvShow.value =
                        ApiResponse.success(response.body() as TvShowResponse)
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG, "onFailure : ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, "Get TvShows Detail onFailure: ${t.message.toString()} ")
                EspressoIdlingResources.decrement()
            }

        })
        return resultDetailTvShow
    }
}


