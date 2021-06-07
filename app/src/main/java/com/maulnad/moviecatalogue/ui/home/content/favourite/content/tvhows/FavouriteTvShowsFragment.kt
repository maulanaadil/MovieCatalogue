package com.maulnad.moviecatalogue.ui.home.content.favourite.content.tvhows

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.databinding.FragmentFavouriteTvShowsBinding
import com.maulnad.moviecatalogue.ui.detail.DetailPageActivity
import com.maulnad.moviecatalogue.viewmodel.ViewModelFactory

class FavouriteTvShowsFragment : Fragment() {

    private var _fragmentFavouriteTvShowBinding: FragmentFavouriteTvShowsBinding? = null
    private val binding get() = _fragmentFavouriteTvShowBinding

    private lateinit var viewModel: FavouriteTvShowsViewModel
    private lateinit var favouriteTvShowAdapter: FavouriteTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavouriteTvShowBinding = FragmentFavouriteTvShowsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavTvShows)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavouriteTvShowsViewModel::class.java]

            favouriteTvShowAdapter = FavouriteTvShowAdapter()
            showLoading(true)
            viewModel.getFavouriteTvShows().observe(viewLifecycleOwner, { tvShows ->
                showLoading(false)
                favouriteTvShowAdapter.submitList(tvShows)
            })
            showRecyclerView()
        }
    }

    private fun showRecyclerView() {
        binding?.let {
            with(it.rvFavTvShows) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = favouriteTvShowAdapter
            }
        }

        favouriteTvShowAdapter.setOnItemCallback(object : FavouriteTvShowAdapter.OnItemCallBack {
            override fun onItemClicked(tvShowId: Int) {
                val intent = Intent(context, DetailPageActivity::class.java)
                    .putExtra(DetailPageActivity.EXTRA_TV, tvShowId)
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
                val tvShowEntity = favouriteTvShowAdapter.getSwipedData(swipedPosition)
                tvShowEntity?.let { viewModel.setFavourite(it) }

                val snackBar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.message_ok) { v ->
                    tvShowEntity?.let { viewModel.setFavourite(it) }
                }
                snackBar.show()
            }
        }

    })

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentFavouriteTvShowBinding = null
    }
}