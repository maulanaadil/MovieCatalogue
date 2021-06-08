package com.maulnad.moviecatalogue.ui.home.content.favourite

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.ui.home.content.favourite.content.movies.FavouriteMoviesFragment
import com.maulnad.moviecatalogue.ui.home.content.favourite.content.tvhows.FavouriteTvShowsFragment

class FavouritePagerAdapter(private val mContext: FavouriteFragment, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLE = intArrayOf(R.string.movies, R.string.tv_shows)

    }

    override fun getCount(): Int = TAB_TITLE.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavouriteMoviesFragment()
            1 -> FavouriteTvShowsFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(TAB_TITLE[position])

}