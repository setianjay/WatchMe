package com.setianjay.watchme.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.setianjay.watchme.R
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.databinding.FragmentFavoriteBinding
import com.setianjay.watchme.ui.favorite.adapter.ViewPagerFavoriteAdapter

class FavoriteFragment : BaseFragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding

    override fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {
        setupTabLayout()
    }

    /**
     * setup tab layout and view pager
     * */
    private fun setupTabLayout(){
        val viewPagerAdapter = ViewPagerFavoriteAdapter(childFragmentManager, lifecycle)
        binding?.vwPager2?.adapter = viewPagerAdapter

        TabLayoutMediator(binding?.tbLayout as TabLayout, binding?.vwPager2 as ViewPager2){ tab, position ->
            if (position == 0){
                tab.text = getString(R.string.categories_movies)
            }else{
                tab.text = getString(R.string.categories_tv_shows)
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}