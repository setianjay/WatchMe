package com.setianjay.watchme.ui.home.contents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.databinding.FragmentContentsBinding
import com.setianjay.watchme.model.Movies
import com.setianjay.watchme.ui.home.adapter.ContentsAdapter
import com.setianjay.watchme.viewmodel.ContentsViewModel

class ContentsFragment private constructor() : BaseFragment() {
    private var _binding: FragmentContentsBinding? = null
    private val binding get() = _binding

    private var isMovies: Boolean? = null

    private val contentsViewModel by viewModels<ContentsViewModel>()

    override fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContentsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {
        specifyContent()
    }

    private fun specifyContent() {
        //obtain data specification for the content
        isMovies = arguments?.getBoolean(ARG_IS_MOVIES)
        isMovies?.let {
            setupRecycleView(it)
        }
    }

    private fun setupRecycleView(isMovies: Boolean) {
        val contents: List<Movies> = contentsViewModel.getDataMovies(isMovies)

        val contentAdapter = ContentsAdapter(requireContext()).apply {
            setContents(contents)
        }
        binding?.rvContent?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = contentAdapter
            setHasFixedSize(true)
        }
    }

    companion object {
        private const val ARG_IS_MOVIES: String = "is_movies"

        fun getInstance(isMovies: Boolean): ContentsFragment {
            val bundle = Bundle().apply {
                putBoolean(ARG_IS_MOVIES, isMovies)
            }

            return ContentsFragment().apply {
                arguments = bundle
            }
        }
    }
}