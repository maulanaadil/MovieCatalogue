package com.maulnad.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
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

        val moviesEntities = viewModel.getMovieDetail(movieId).value
        verify(catalogueRepository).getDetailMovie(movieId)
        assertNotNull(moviesEntities)
        assertEquals(dummyMovie.movieId, moviesEntities?.movieId)
        assertEquals(dummyMovie.title, moviesEntities?.title)
        assertEquals(dummyMovie.description, moviesEntities?.description)
        assertEquals(dummyMovie.poster, moviesEntities?.poster)
        assertEquals(dummyMovie.backDrop, moviesEntities?.backDrop)

        viewModel.detailMovie.observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)

    }

    @Test
    fun getTvShowDetail() {
        val tvShowDummy = MutableLiveData<TvShowEntity>()
        tvShowDummy.value = dummyTvShow

        Mockito.`when`(catalogueRepository.getDetailTvShow(tvShowId)).thenReturn(tvShowDummy)

        val tvShowEntities = viewModel.getTvShowDetail(tvShowId).value
        verify(catalogueRepository).getDetailTvShow(tvShowId)
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.tvShowId, tvShowEntities?.tvShowId)
        assertEquals(dummyTvShow.title, tvShowEntities?.title)
        assertEquals(dummyTvShow.description, tvShowEntities?.description)
        assertEquals(dummyTvShow.poster, tvShowEntities?.poster)
        assertEquals(dummyTvShow.backDrop, tvShowEntities?.backDrop)

        viewModel.detailTvShow.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)

    }
}