package com.setianjay.watchme.ui.home.contents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.databinding.FragmentContentsBinding
import com.setianjay.watchme.model.Movies
import com.setianjay.watchme.ui.home.HomeFragmentDirections
import com.setianjay.watchme.ui.home.adapter.ContentsAdapter
import com.setianjay.watchme.viewmodel.ContentsViewModel

class ContentsFragment private constructor() : BaseFragment(), ContentsAdapter.IOnContentsAdapterListener {
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

    /**
     * specify content whether movies or tv shows
     * */
    private fun specifyContent() {
        //obtain data specification for the content
        isMovies = arguments?.getBoolean(ARG_IS_MOVIES)
        isMovies?.let {
            setupRecycleView(it)
        }
    }

    /**
     * setup recyclerview based on content
     *
     * @param isMovies if true the content is movies, otherwise tv shows
     * */
    private fun setupRecycleView(isMovies: Boolean) {
        val contents: List<Movies> = contentsViewModel.getDataMovies(isMovies)

        val contentAdapter = ContentsAdapter(requireContext(), this).apply {
            setContents(contents)
        }
        binding?.rvContent?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = contentAdapter
            setHasFixedSize(true)
        }
    }

    /**
     * when one of item in movies list has clicked, move them to DetailMovieFragment
     *
     * @param position position of item
     * */
    override fun onClickItem(position: Int) {
        //send position and state of movie to DetailMovieFragment through SafeArgs
        val toDetailMovieFragment = HomeFragmentDirections.actionHomeFragmentToDetailMovieFragment(position, isMovies ?: false)
        findNavController().navigate(toDetailMovieFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        //unbind fragment
        _binding = null
    }

    companion object {
        //key of arguments is movies
        private const val ARG_IS_MOVIES: String = "is_movies"

        /**
         * get instance for ContentsFragment must through this function
         *
         * @param   isMovies true for categories movies, otherwise tv shows
         * @return  ContentsFragment
         * */
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