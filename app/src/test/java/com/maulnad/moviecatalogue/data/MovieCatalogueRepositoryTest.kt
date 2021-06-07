package com.maulnad.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.maulnad.moviecatalogue.data.source.remote.RemoteDataSource
import com.maulnad.moviecatalogue.utils.DataDummy
import com.maulnad.moviecatalogue.utils.LiveDataTestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test

import org.mockito.Mockito

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieCatalogueRepository = FakeCatalogueRepository(remote)

    private val listMovieResponse = DataDummy.generateDataDummyMoviesResponse()
    private val movieId = listMovieResponse[0].id
    private val movieResponses = DataDummy.generateDataDummyMoviesResponse()[0]

    private val listTvResponse = DataDummy.generateDataDummyTvShowsResponse()
    private val tvShowId = listTvResponse[0].id
    private val tvShowResponses = DataDummy.generateDataDummyTvShowsResponse()[0]


    @Test
    fun getAllMovie() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMovieReceived(listMovieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getAllMovie())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(listMovieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getTvShow() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(listTvResponse)
            null
        }.`when`(remote).getAllTvShows(any())
        val tvEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getAllTvShow())
        verify(remote).getAllTvShows(any())
        assertNotNull(tvEntities)
        assertEquals(listTvResponse.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMoviesDetailCallback)
                .onMovieDetailReceived(movieResponses)
            null
        }.`when`(remote).getDetailMovies(any(), eq(movieId))
        val movieEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getDetailMovie(movieId))

        verify(remote).getDetailMovies(any(), eq(movieId))

        assertNotNull(movieEntities)
        assertEquals(movieResponses.id, movieEntities.movieId)

    }

    @Test
    fun getDetailTvShow() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvShowsDetailCallback)
                .onTvShowDetailReceived(tvShowResponses)
            null
        }.`when`(remote).getDetailTvShow(any(), eq(tvShowId))
        val tvShowEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getDetailTvShow(tvShowId))

        verify(remote).getDetailTvShow(any(), eq(tvShowId))
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.id, tvShowEntities.tvShowId)
    }
}