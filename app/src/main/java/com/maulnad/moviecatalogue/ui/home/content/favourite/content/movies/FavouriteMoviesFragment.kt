package com.maulnad.moviecatalogue.ui.home.content.favourite.content.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.databinding.FragmentFavouriteMoviesBinding
import com.maulnad.moviecatalogue.ui.detail.DetailPageActivity
import com.maulnad.moviecatalogue.viewmodel.ViewModelFactory


class FavouriteMoviesFragment : Fragment() {

    private var _fragmentFavouriteMoviesBinding: FragmentFavouriteMoviesBinding? = null
    private val binding get() = _fragmentFavouriteMoviesBinding

    private lateinit var viewModel: FavouriteMoviesViewModel
    private lateinit var favouriteMovieAdapter: FavouriteMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavouriteMoviesBinding =
            FragmentFavouriteMoviesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavMovies)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavouriteMoviesViewModel::class.java]

            favouriteMovieAdapter = FavouriteMoviesAdapter()

            showLoading(true)
            viewModel.getFavouriteMovies().observe(viewLifecycleOwner, { movies ->
                showLoading(false)
                favouriteMovieAdapter.submitList(movies)
            })
            showRecyclerView()
        } else {
            Toast.makeText(requireContext(), "Error bro", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showRecyclerView() {
        binding?.let {
            with(it.rvFavMovies) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = favouriteMovieAdapter
            }
        }

        favouriteMovieAdapter.setOnItemCallback(object : FavouriteMoviesAdapter.OnItemCallback {
            override fun onItemClicked(movieId: Int) {
                val intent = Intent(context, DetailPageActivity::class.java)
                    .putExtra(DetailPageActivity.EXTRA_MOVIE, movieId)
                startActivity(intent)
            }

        })

    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
        } else {
            binding?.progressBar?.visibility = View.INVISIBLE
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = favouriteMovieAdapter.getSwipedData(swipedPosition)
                movieEntity?.let { viewModel.setFavourite(it) }

                val snackBar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.message_ok) { v ->
                    movieEntity?.let { viewModel.setFavourite(it) }
                }
                snackBar.show()
            }
        }

    })

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentFavouriteMoviesBinding = null
    }

}