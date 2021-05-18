package com.maulnad.moviecatalogue.ui.home.content.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.maulnad.moviecatalogue.data.model.DataEntity
import com.maulnad.moviecatalogue.databinding.FragmentMoviesBinding
import com.maulnad.moviecatalogue.ui.detail.DetailPageActivity
import com.maulnad.moviecatalogue.ui.home.content.ContentCallback
import com.maulnad.moviecatalogue.viewmodel.ViewModelFactory

class MoviesFragment : Fragment(), ContentCallback {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val moviesAdapter = MoviesAdapter(this@MoviesFragment)

            fragmentMoviesBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovies().observe(this, {
                fragmentMoviesBinding.progressBar.visibility = View.GONE
                moviesAdapter.setMovies(it)
                moviesAdapter.notifyDataSetChanged()
            })

            with(fragmentMoviesBinding.rvMovies) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }
        }
    }

    override fun onItemClicked(data: DataEntity) {
        startActivity(
            Intent(context, DetailPageActivity::class.java)
                .putExtra(DetailPageActivity.EXTRA_MOVIE, data.movieId)
        )
    }
}