package com.maulnad.moviecatalogue.ui.detail

import  androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private  val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    private  val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: CatalogueRepository


    @Mock
    private lateinit var moviesObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(repository)
        viewModel.selectedMovie(movieId)
        viewModel.selectedTvShow(tvShowId)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(repository.getDetailMovie(movieId)).thenReturn(movie)

        val movieEntities = viewModel.getDetailMovie(movieId).value as MovieEntity

        assertNotNull(movieEntities)
        assertEquals(dummyMovie.title, movieEntities.title)
        assertEquals(dummyMovie.description, movieEntities.description)
        assertEquals(dummyMovie.poster, movieEntities.poster)

        viewModel.getDetailMovie(movieId).observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyMovie)
    }

    @Test
    fun getDetailTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(repository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
        val tvShowEntities = viewModel.getDetailTvShow(tvShowId).value as TvShowEntity
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.title, tvShowEntities.title)
        assertEquals(dummyTvShow.description, tvShowEntities.description)
        assertEquals(dummyTvShow.poster, tvShowEntities.poster)

        viewModel.getDetailTvShow(tvShowId).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}