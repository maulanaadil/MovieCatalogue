package com.maulnad.moviecatalogue.ui.home.content.favourite.content.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
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
class FavouriteMoviesViewModelTest {
    private lateinit var viewModel: FavouriteMoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var movie: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavouriteMoviesViewModel(catalogueRepository)
    }

    @Test
    fun getFavouriteMovies() {
        val dummyMovie = movie
        `when`(dummyMovie.size).thenReturn(10)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovie

        `when`(catalogueRepository.getListFavouriteMovie()).thenReturn(movie)
        val movieEntity = viewModel.getFavouriteMovies().value
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity?.size)

        viewModel.getFavouriteMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}