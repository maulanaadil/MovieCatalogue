package com.maulnad.moviecatalogue.ui.home.content.favourite.content.tvhows

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.databinding.ItemsFavouritePosterBinding
import com.maulnad.moviecatalogue.ui.home.content.ContentCallback
import com.maulnad.moviecatalogue.utils.Helper

class FavouriteTvShowAdapter :
    PagedListAdapter<TvShowEntity, FavouriteTvShowAdapter.TvShowsViewHolder>(DIFF_CALLBACK) {
    private lateinit var onItemCallBack: OnItemCallBack

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class TvShowsViewHolder(private val binding: ItemsFavouritePosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShow.title

                Glide.with(itemView.context)
                    .load(Helper.IMAGE_URL_TMDD_ENDPOINT + Helper.IMAGE_URL_SIZE_ENDPOINT + tvShow.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivPoster)

                itemView.setOnClickListener {
                    onItemCallBack.onItemClicked(tvShow.tvShowId)
                }

                ivShare.setOnClickListener {
                    Toast.makeText(itemView.context, "Shared ${tvShow.title}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onBindViewHolder(holder: FavouriteTvShowAdapter.TvShowsViewHolder, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouriteTvShowAdapter.TvShowsViewHolder {
        val itemsFavouritePosterBinding =
            ItemsFavouritePosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(itemsFavouritePosterBinding)
    }

    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    fun setOnItemCallback(onItemCallBack: OnItemCallBack) {
        this.onItemCallBack = onItemCallBack
    }

    interface OnItemCallBack {
        fun onItemClicked(tvShowId: Int)
    }
}