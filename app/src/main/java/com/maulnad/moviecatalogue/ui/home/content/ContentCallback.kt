package com.maulnad.moviecatalogue.ui.home.content

import com.maulnad.moviecatalogue.model.DataEntity

interface ContentCallback {

    fun onItemClicked(data: DataEntity)
}