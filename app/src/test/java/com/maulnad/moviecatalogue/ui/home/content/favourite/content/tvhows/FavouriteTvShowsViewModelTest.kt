package com.maulnad.moviecatalogue.ui.home.content.favourite.content.tvhows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.maulnad.moviecatalogue.data.source.CatalogueRepository
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavouriteTvShowsViewModelTest {
    private lateinit var viewModel: FavouriteTvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var tvShow: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavouriteTvShowsViewModel(catalogueRepository)
    }

    @Test
    fun getFavouriteTvShows() {
        val dummyTvShow = tvShow
        `when`(dummyTvShow.size).thenReturn(10)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow

        `when`(catalogueRepository.getListFavouriteTvShow()).thenReturn(tvShow)

        val tvShowEntity = viewModel.getFavouriteTvShows().value

        assertNotNull(tvShowEntity)
        assertEquals(10, tvShowEntity?.size)

        viewModel.getFavouriteTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}