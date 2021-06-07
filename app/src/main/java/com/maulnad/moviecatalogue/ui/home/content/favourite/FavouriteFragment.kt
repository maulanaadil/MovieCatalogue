package com.maulnad.moviecatalogue.ui.home.content.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maulnad.moviecatalogue.databinding.FragmentFavouriteBinding


class FavouriteFragment : Fragment() {

    private var _fragmentFavouriteBinding: FragmentFavouriteBinding? = null
    private val binding get() = _fragmentFavouriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavouriteBinding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favouritePagerAdapter =
            FavouritePagerAdapter(this, requireActivity().supportFragmentManager)
        binding?.viewPager?.adapter = favouritePagerAdapter
        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentFavouriteBinding = null
    }
}