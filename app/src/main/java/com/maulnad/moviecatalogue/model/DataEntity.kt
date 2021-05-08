package com.maulnad.moviecatalogue.model

data class DataEntity(
    var movieId: String,
    var title: String,
    var description: String,
    var releaseDate: String,
    var genre: String,
    var imagePath: Int
)