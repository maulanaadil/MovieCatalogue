package com.maulnad.moviecatalogue.ui.home.content

import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity

interface ContentCallback {

    fun onItemMovieClicked(movie: MovieEntity)

    fun onItemTvShowClicked(tvShow: TvShowEntity)
}