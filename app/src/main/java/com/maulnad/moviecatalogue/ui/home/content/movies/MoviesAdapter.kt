package com.maulnad.moviecatalogue.ui.home.content.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.databinding.ItemsPosterBinding
import com.maulnad.moviecatalogue.model.DataEntity
import com.maulnad.moviecatalogue.ui.detail.DetailPageActivity
import com.maulnad.moviecatalogue.ui.home.content.ContentCallback

class MoviesAdapter(private val contentCallback: ContentCallback):
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var listMovies = ArrayList<DataEntity>()

    fun setMovies(movies: List<DataEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    inner class MoviesViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: DataEntity) {
            with(binding) {
                tvTitle.text = movies.title
                tvGenre.text = movies.genre

                Glide.with(itemView.context)
                    .load(movies.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivPoster)

                itemView.setOnClickListener {
                    contentCallback.onItemClicked(movies)

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
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size
}