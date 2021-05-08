package com.maulnad.moviecatalogue.ui.detail

import com.maulnad.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {
    private lateinit var detailViewModel: DetailViewModel
    private  val dummyMovie = DataDummy.generateDummyMovies()[0]
    private  val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId = dummyMovie.movieId
    private val tvShowId = dummyTvShow.movieId

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
        detailViewModel.setMovieId(movieId)
        detailViewModel.setTvShowId(tvShowId)

    }

    @Test
    fun getDetailMovie() {
        val movieEntities = detailViewModel.getDetailMovie()
        assertNotNull(movieEntities)
        assertEquals(dummyMovie.title, movieEntities.title)
        assertEquals(dummyMovie.genre, movieEntities.genre)
        assertEquals(dummyMovie.description, movieEntities.description)
        assertEquals(dummyMovie.releaseDate, movieEntities.releaseDate)
        assertEquals(dummyMovie.imagePath, movieEntities.imagePath)
    }

    @Test
    fun getDetailTvShow() {
        val tvShowEntities = detailViewModel.getDetailTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.title, tvShowEntities.title)
        assertEquals(dummyTvShow.genre, tvShowEntities.genre)
        assertEquals(dummyTvShow.description, tvShowEntities.description)
        assertEquals(dummyTvShow.releaseDate, tvShowEntities.releaseDate)
        assertEquals(dummyTvShow.imagePath, tvShowEntities.imagePath)
    }
}