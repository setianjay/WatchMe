package com.setianjay.watchme.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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
        initListener()
    }

    /**
     * setup tab layout and view pager2
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

    private fun initListener() {
        binding?.ivMenu?.setOnClickListener {
            showPopupMenu()
        }
    }

    /**
     * show popup menu
     * */
    private fun showPopupMenu() {
        val popupMenu = PopupMenu(requireContext(), binding?.ivMenu).apply {
            menuInflater.inflate(R.menu.home_menu, this.menu)
        }

        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem? ->
            if (menuItem?.itemId == R.id.action_menu_fav_movie){
                findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
            }
            true
        }

        popupMenu.show()
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