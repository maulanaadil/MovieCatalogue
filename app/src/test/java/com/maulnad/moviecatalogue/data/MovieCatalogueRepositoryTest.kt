package com.maulnad.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.maulnad.moviecatalogue.data.source.FakeCatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.LocalDataSource
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.data.source.remote.RemoteDataSource
import com.maulnad.moviecatalogue.utils.AppExecutors
import com.maulnad.moviecatalogue.utils.DataDummy
import com.maulnad.moviecatalogue.utils.LiveDataTestUtils
import com.maulnad.moviecatalogue.utils.PagedListUtil
import com.maulnad.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val fakeCatalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val listMovie = DataDummy.generateDummyMovies()
    private val movie = DataDummy.generateDummyMovies()[0]

    private val listTv = DataDummy.generateDummyTvShow()
    private val tvShow = DataDummy.generateDummyTvShow()[0]


    @Test
    fun getAllMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getListMovies()).thenReturn(dataSourceFactory)
        fakeCatalogueRepository.getAllMovie()

        val moviesEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getListMovies()
        assertNotNull(moviesEntities)
        assertEquals(listMovie.size.toLong(), moviesEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getListTvShows()).thenReturn(dataSourceFactory)
        fakeCatalogueRepository.getAllTvShow()

        val tvShowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getListTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(listTv.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyMovies = MutableLiveData<MovieEntity>()
        dummyMovies.value = movie
        `when`(local.getDetailMovieById(tvShow.tvShowId)).thenReturn(dummyMovies)

        val movieEntities =
            LiveDataTestUtils.getValue(fakeCatalogueRepository.getDetailMovie(movie.movieId))
        verify(local).getDetailMovieById(movie.movieId)
        assertNotNull(movieEntities)
        assertEquals(movie.movieId, movieEntities.movieId)

    }

    @Test
    fun getDetailTvShow() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = tvShow
        `when`(local.getDetailTvShowById(tvShow.tvShowId)).thenReturn(dummyTvShow)

        val tvShowEntities =
            LiveDataTestUtils.getValue(fakeCatalogueRepository.getDetailTvShow(tvShow.tvShowId))
        verify(local).getDetailTvShowById(tvShow.tvShowId)
        assertNotNull(tvShowEntities)
        assertEquals(tvShow.tvShowId, tvShowEntities.tvShowId)
    }

    @Test
    fun getListFavouriteMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getListFavouriteMovies()).thenReturn(dataSourceFactory)
        fakeCatalogueRepository.getListFavouriteMovie()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getListFavouriteMovies()
        assertEquals(listMovie.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getListFavouriteTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getListFavouriteTvShows()).thenReturn(dataSourceFactory)
        fakeCatalogueRepository.getListFavouriteTvShow()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getListFavouriteTvShows()
        assertEquals(listMovie.size.toLong(), movieEntities.data?.size?.toLong())
    }
}