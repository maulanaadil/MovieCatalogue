package com.maulnad.moviecatalogue.data.source.remote.api

import com.maulnad.moviecatalogue.BuildConfig
import com.maulnad.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.maulnad.moviecatalogue.data.source.remote.response.MovieResponse
import com.maulnad.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import com.maulnad.moviecatalogue.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getDiscoverMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDBApi
    ) : Call<MovieResponse>

    @GET("movie/{id}")
    fun getDetailMovie(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDBApi
    ): Call<MovieDetailResponse>

    @GET("discover/tv")
    fun getDiscoverTvShow(
        @Query("api_key") apiKey: String = BuildConfig.TMDBApi
    ): Call<TvShowResponse>

    @GET("tv/{id}")
    fun getDetailTvShow(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDBApi
    ): Call<TvShowDetailResponse>
}