package com.maulnad.moviecatalogue.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataEntity(
    var movieId: Int,
    var title: String,
    var description: String,
    var poster: String,
    var backDrop: String,
) : Parcelable