package com.maulnad.moviecatalogue.ui.home.content.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.maulnad.moviecatalogue.databinding.FragmentMoviesBinding
import com.maulnad.moviecatalogue.model.DataEntity
import com.maulnad.moviecatalogue.ui.detail.DetailPageActivity
import com.maulnad.moviecatalogue.ui.home.content.ContentCallback

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

            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[MoviesViewModel::class.java]
            val movies = viewModel.getMovies()

            val moviesAdapter = MoviesAdapter(this@MoviesFragment)
            moviesAdapter.setMovies(movies)

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