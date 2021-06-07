package com.maulnad.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListResponse<T>(

    @SerializedName("status_message")
    val status_message: String? = null,

    @SerializedName("status_code")
    val status_code: Int? = null,

    @SerializedName("results")
    val results: List<T>? = null,
)