package com.setianjay.watchme.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.setianjay.watchme.R
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.databinding.FragmentDetailMovieBinding
import com.setianjay.watchme.utils.ViewUtil.load
import com.setianjay.watchme.viewmodel.ContentsViewModel

class DetailMovieFragment : BaseFragment() {
    private var _binding: FragmentDetailMovieBinding? = null
    private val binding get() = _binding

    private val contentsViewModel by viewModels<ContentsViewModel>()

    override fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {
        showDetailMovie()
    }

    /**
     * show detail movie based on movie by user clicked
     * */
    private fun showDetailMovie() {
        val position: Int
        val isMovies: Boolean
        DetailMovieFragmentArgs.fromBundle(arguments as Bundle).apply {
            position = this.position
            isMovies = this.isMovies
        }

        val movie = contentsViewModel.getSpecificDataMovies(position, isMovies)

        binding?.apply {
            ivPoster.load(movie.poster)
            tvTitle.text = movie.title
            tvGenre.text = movie.genre.joinToString(",")
            tvDuration.text = movie.duration
            tvDirector.text = resources.getString(R.string.director, movie.director)
            rating.rating = movie.rating
            tvRating.text = "${movie.rating}"
            tvOverview.text = movie.overview
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //unbind fragment
        _binding = null
    }
}