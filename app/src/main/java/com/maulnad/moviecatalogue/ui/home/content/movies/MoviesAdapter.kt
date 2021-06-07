package com.maulnad.moviecatalogue.ui.home.content.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.databinding.ItemsPosterBinding
import com.maulnad.moviecatalogue.ui.home.content.ContentCallback
import com.maulnad.moviecatalogue.utils.Helper.IMAGE_URL_SIZE_ENDPOINT
import com.maulnad.moviecatalogue.utils.Helper.IMAGE_URL_TMDD_ENDPOINT

class MoviesAdapter:
    PagedListAdapter<MovieEntity, MoviesAdapter.MoviesViewHolder>(DIFF_CALLBACK) {
    private lateinit var onItemCallBack: OnItemCallBack

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

    inner class MoviesViewHolder(private val binding: ItemsPosterBinding) :
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
                    onItemCallBack.onItemClicked(movies.movieId)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MoviesViewHolder {
        val itemsPosterBinding =
            ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsPosterBinding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }

    fun setOnItemClickCallback(onItemCallBack: OnItemCallBack) {
        this.onItemCallBack = onItemCallBack
    }

    interface OnItemCallBack {
        fun onItemClicked(movieId: Int)
    }

}