package com.setianjay.watchme.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.setianjay.watchme.R
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.databinding.FragmentDetailMovieBinding

class DetailMovieFragment : BaseFragment() {
    private var _binding: FragmentDetailMovieBinding? = null
    private val binding get() = _binding

    override fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}