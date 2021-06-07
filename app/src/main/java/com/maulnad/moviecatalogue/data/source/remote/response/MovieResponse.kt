package com.maulnad.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
	@SerializedName("id")
	val id: Int,

	@SerializedName("title")
	val title: String,

	@SerializedName("overview")
	val overview: String,

	@SerializedName("poster_path")
	val posterPath: String,

	@SerializedName("backdrop_path")
	val backgroundPath: String,
)
