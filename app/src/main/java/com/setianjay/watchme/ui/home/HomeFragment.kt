package com.setianjay.watchme.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.setianjay.watchme.R
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.databinding.FragmentHomeBinding
import com.setianjay.watchme.ui.home.adapter.ViewPagerHomeAdapter


class HomeFragment : BaseFragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {
        setupTabLayout()
    }

    /**
     * setup between tab layout and view pager2
     * */
    private fun setupTabLayout() {
        val viewPagerAdapter = ViewPagerHomeAdapter(childFragmentManager, lifecycle)
        binding?.vwPager2?.adapter = viewPagerAdapter

        binding?.tbLayout?.let { tabLayout ->
            binding?.vwPager2?.let { viewPager ->
                TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                    if (position == 0) {
                        tab.text = getString(R.string.categories_movies)
                    } else {
                        tab.text = getString(R.string.categories_tv_shows)
                    }
                }.attach()
            }
        }
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