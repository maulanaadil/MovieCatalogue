package com.maulnad.moviecatalogue.ui.home.content.movies

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setup() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}