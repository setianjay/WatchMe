package com.setianjay.watchme.ui.favorite.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.setianjay.watchme.ui.favorite.contents.ContentsFavoriteFragment

class ViewPagerFavoriteAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        val isMovies = position == 0
        return ContentsFavoriteFragment.getInstance(isMovies)
    }

}