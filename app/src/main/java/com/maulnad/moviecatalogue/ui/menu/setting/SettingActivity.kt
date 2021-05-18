package com.maulnad.moviecatalogue.ui.menu.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maulnad.moviecatalogue.R

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}