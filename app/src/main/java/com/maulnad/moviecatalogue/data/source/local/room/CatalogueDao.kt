package com.maulnad.moviecatalogue.data.source.local.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface CatalogueDao {

    // movies
    @Query("SELECT * FROM movieentities")
    fun getListMovies(): DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getDetailMovieById(movieId: Int): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @WorkerThread
    @Query("SELECT * FROM movieentities WHERE favourite = 1")
    fun getListFavouriteMovie(): DataSource.Factory<Int, MovieEntity>


    // tvShows
    @Query("SELECT * FROM tvshowentities")
    fun getListTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
    fun getDetailTvShowById(tvShowId: Int): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)

    @Query("SELECT * FROM tvshowentities WHERE favourite = 1")
    fun getListFavouriteTvShow(): DataSource.Factory<Int, TvShowEntity>


}