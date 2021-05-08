package com.maulnad.moviecatalogue.ui.home.content.tvshows

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.maulnad.moviecatalogue.databinding.FragmentTvShowsBinding
import com.maulnad.moviecatalogue.model.DataEntity
import com.maulnad.moviecatalogue.ui.detail.DetailPageActivity
import com.maulnad.moviecatalogue.ui.home.content.ContentCallback

class TvShowsFragment : Fragment(), ContentCallback {
    private lateinit var fragmentTvShowsBinding: FragmentTvShowsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return fragmentTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[TvShowsViewModel::class.java]
            val tvShows = viewModel.getTvShows()

            val tvShowsAdapter = TvShowsAdapter(this@TvShowsFragment)
            tvShowsAdapter.setTvShows(tvShows)

            with(fragmentTvShowsBinding.rvTvShows) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }

    override fun onItemClicked(data: DataEntity) {
        startActivity(
            Intent(context, DetailPageActivity::class.java)
                .putExtra(DetailPageActivity.EXTRA_TV, data.movieId)
        )
    }
}