package com.maulnad.moviecatalogue.ui.setting

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {

    private lateinit var settingBinding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        settingBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(settingBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        
        settingBinding.tvChangeLanguage.setOnClickListener {
            // TODO: 08/06/2021 Change Language
        }
        
        settingBinding.tvHelp.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themoviedb.org/faq/website"))
            startActivity(intent)
        }
    }
}