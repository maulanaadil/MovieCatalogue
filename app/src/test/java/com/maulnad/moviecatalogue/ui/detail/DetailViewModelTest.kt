package com.maulnad.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>

    @Mock
    private lateinit var observerTvShow: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getMovieDetail() {
        val movieDummy = MutableLiveData<MovieEntity>()
        movieDummy.value = dummyMovie

        Mockito.`when`(catalogueRepository.getDetailMovie(movieId)).thenReturn(movieDummy)

        val movieData = viewModel.getMovieDetail(movieId).value

        assertNotNull(movieData)
        assertEquals(dummyMovie.movieId, movieData?.movieId)
        assertEquals(dummyMovie.title, movieData?.title)
        assertEquals(dummyMovie.description, movieData?.description)
        assertEquals(dummyMovie.poster, movieData?.poster)
        assertEquals(dummyMovie.backDrop, movieData?.backDrop)

        viewModel.detailMovie.observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)

    }

    @Test
    fun getTvShowDetail() {
        val tvShowDummy = MutableLiveData<TvShowEntity>()
        tvShowDummy.value = dummyTvShow

        Mockito.`when`(catalogueRepository.getDetailTvShow(tvShowId)).thenReturn(tvShowDummy)

        val tvShow = viewModel.getTvShowDetail(tvShowId).value

        assertNotNull(tvShow)
        assertEquals(dummyTvShow.tvShowId, tvShow?.tvShowId)
        assertEquals(dummyTvShow.title, tvShow?.title)
        assertEquals(dummyTvShow.description, tvShow?.description)
        assertEquals(dummyTvShow.poster, tvShow?.poster)
        assertEquals(dummyTvShow.backDrop, tvShow?.backDrop)

        viewModel.detailTvShow.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)

    }
}