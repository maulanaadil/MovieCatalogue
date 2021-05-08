package com.maulnad.moviecatalogue.ui.home.content.tvshows

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TvShowsViewModelTest {
    private lateinit var viewModel: TvShowsViewModel

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShowEntities = viewModel.getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}