package com.maulnad.moviecatalogue.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.databinding.ActivityHomeBinding
import com.maulnad.moviecatalogue.ui.home.content.favourite.FavouriteFragment
import com.maulnad.moviecatalogue.ui.home.content.movies.MoviesFragment
import com.maulnad.moviecatalogue.ui.home.content.tvshows.TvShowsFragment
import com.maulnad.moviecatalogue.ui.menu.setting.SettingActivity


class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        setSupportActionBar(activityHomeBinding.toolbar)
        supportActionBar?.apply {
            elevation = 0f
            title = ""
        }


        loadFragment(MoviesFragment())
        activityHomeBinding.bottomNav.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener
        )

    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_movie ->loadFragment(MoviesFragment())
                R.id.navigation_tvShow -> loadFragment(TvShowsFragment())
                R.id.navigation_favourite -> loadFragment(FavouriteFragment())
            }
            true
        }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.setting_nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_setting -> {
                val intent = Intent(this@HomeActivity, SettingActivity::class.java)
                startActivity(intent)
            }
            else -> return true
        }
        return true
    }
}