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
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var moviesObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(catalogueRepository.getDetailMovie(movieId)).thenReturn(movie)

        val movieEntities = viewModel.detailMovie.value

        assertNotNull(movieEntities)
        assertEquals(dummyMovie.movieId, movieEntities?.movieId)
        assertEquals(dummyMovie.title, movieEntities?.title)
        assertEquals(dummyMovie.description, movieEntities?.description)
        assertEquals(dummyMovie.poster, movieEntities?.poster)
        assertEquals(dummyMovie.backDrop, movieEntities?.backDrop)

        viewModel.detailMovie.observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyMovie)
    }

    @Test
    fun getDetailTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(catalogueRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
        val tvShowEntities = viewModel.detailTvShow.value
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.tvShowId, tvShowEntities?.tvShowId)
        assertEquals(dummyTvShow.title, tvShowEntities?.title)
        assertEquals(dummyTvShow.description, tvShowEntities?.description)
        assertEquals(dummyTvShow.poster, tvShowEntities?.poster)
        assertEquals(dummyTvShow.backDrop, tvShowEntities?.backDrop)

        viewModel.detailTvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}