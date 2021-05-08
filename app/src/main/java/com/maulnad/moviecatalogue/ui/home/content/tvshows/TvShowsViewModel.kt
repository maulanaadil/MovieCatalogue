package com.maulnad.moviecatalogue.ui.home.content.tvshows

import androidx.lifecycle.ViewModel
import com.maulnad.moviecatalogue.model.DataEntity
import com.maulnad.moviecatalogue.utils.DataDummy

class TvShowsViewModel : ViewModel() {
    fun getTvShows(): List<DataEntity> = DataDummy.generateDummyTvShows()
}