package com.setianjay.watchme.ui.home.contents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.databinding.FragmentContentsBinding
import com.setianjay.watchme.ui.home.HomeFragmentDirections
import com.setianjay.watchme.ui.home.adapter.ContentsAdapter
import com.setianjay.watchme.utils.ViewUtil.show
import timber.log.Timber

class ContentsFragment private constructor() : BaseFragment(),
    ContentsAdapter.IOnContentsAdapterListener {
    private var _binding: FragmentContentsBinding? = null
    private val binding get() = _binding

    private val contentsViewModel by viewModels<ContentsViewModel> {
        movieViewModelFactory
    }

    private var isMovies: Boolean? = null
    private var movies: List<MovieEntity>? = null

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
        Timber.d("Init created")
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
        val contentsAdapter = ContentsAdapter(requireContext(), this)

        //get observer for content based on parameter
        observer(isMovies, contentsAdapter)

        binding?.rvContent?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = contentsAdapter
            setHasFixedSize(true)
        }
    }

    private fun observer(isMovies: Boolean, adapter: ContentsAdapter) {
        if (isMovies) {
            contentsViewModel.getDataMovies().observe(viewLifecycleOwner) { response ->
                when (response.statusType) {
                    Resource.StatusType.LOADING -> {
                        binding?.pbLoading?.show(true)
                    }
                    Resource.StatusType.SUCCESS -> {
                        binding?.pbLoading?.show(false)
                        movies = response?.data
                        movies?.let { adapter.setContents(it) }
                    }
                    Resource.StatusType.ERROR -> {
                        binding?.pbLoading?.show(false)
                    }
                }
            }
        } else {
            contentsViewModel.getTvMovie().observe(viewLifecycleOwner) { response ->
                when (response.statusType) {
                    Resource.StatusType.LOADING -> {
                        binding?.pbLoading?.show(true)
                    }
                    Resource.StatusType.SUCCESS -> {
                        binding?.pbLoading?.show(false)
                        movies = response?.data
                        movies?.let { adapter.setContents(it) }
                    }
                    Resource.StatusType.ERROR -> {
                        binding?.pbLoading?.show(false)
                    }
                }
            }
        }
    }

    /**
     * when one of item in movies list has clicked, move them to DetailMovieFragment
     *
     * @param movieId id of movie
     * */
    override fun onClickItem(movieId: Long) {
        //send movie id and state of movie to DetailMovieFragment through SafeArgs
        val toDetailMovieFragment = HomeFragmentDirections.actionHomeFragmentToDetailMovieFragment(
            movieId,
            isMovies ?: false
        )
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