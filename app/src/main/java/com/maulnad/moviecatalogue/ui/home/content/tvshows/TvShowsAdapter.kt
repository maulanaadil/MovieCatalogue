package com.maulnad.moviecatalogue.ui.home.content.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.data.model.DataEntity
import com.maulnad.moviecatalogue.databinding.ItemsPosterBinding
import com.maulnad.moviecatalogue.ui.home.content.ContentCallback
import com.maulnad.moviecatalogue.utils.Helper

class TvShowsAdapter(private val contentCallback: ContentCallback) :
    RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {
    private var listTvShows = ArrayList<DataEntity>()

    fun setTvShows(tvShows: List<DataEntity>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
        notifyDataSetChanged()
    }

    inner class TvShowsViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: DataEntity) {
            with(binding) {
                tvTitle.text = tvShows.title

                Glide.with(itemView.context)
                    .load(Helper.IMAGE_URL_TMDD_ENDPOINT + Helper.IMAGE_URL_SIZE_ENDPOINT + tvShows.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivPoster)

                itemView.setOnClickListener {
                    contentCallback.onItemClicked(tvShows)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowsAdapter.TvShowsViewHolder {
        val itemsPosterBinding =
            ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(itemsPosterBinding)
    }

    override fun onBindViewHolder(holder: TvShowsAdapter.TvShowsViewHolder, position: Int) {
        val tvShows = listTvShows[position]
        holder.bind(tvShows)
    }

    override fun getItemCount(): Int = listTvShows.size

}