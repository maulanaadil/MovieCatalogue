package com.maulnad.moviecatalogue.ui.home.content.favourite.content.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.databinding.ItemsFavouritePosterBinding
import com.maulnad.moviecatalogue.ui.home.content.ContentCallback
import com.maulnad.moviecatalogue.utils.Helper.IMAGE_URL_SIZE_ENDPOINT
import com.maulnad.moviecatalogue.utils.Helper.IMAGE_URL_TMDD_ENDPOINT

class FavouriteMoviesAdapter :
    PagedListAdapter<MovieEntity, FavouriteMoviesAdapter.MoviesViewHolder>(DIFF_CALLBACK) {
    private lateinit var onItemCallback: OnItemCallback

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class MoviesViewHolder(private val binding: ItemsFavouritePosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MovieEntity) {
            with(binding) {
                tvTitle.text = movies.title

                Glide.with(itemView.context)
                    .load(IMAGE_URL_TMDD_ENDPOINT + IMAGE_URL_SIZE_ENDPOINT + movies.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivPoster)

                itemView.setOnClickListener {
                    onItemCallback.onItemClicked(movies.movieId)
                }

                ivShare.setOnClickListener {
                    Toast.makeText(itemView.context, "Shared ${movies.title}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onBindViewHolder(holder: FavouriteMoviesAdapter.MoviesViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouriteMoviesAdapter.MoviesViewHolder {
        val itemsFavouritePosterBinding =
            ItemsFavouritePosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsFavouritePosterBinding)
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)

    fun setOnItemCallback(onItemCallback: OnItemCallback) {
        this.onItemCallback = onItemCallback
    }


    interface OnItemCallback {
        fun onItemClicked(movieId: Int)
    }

}