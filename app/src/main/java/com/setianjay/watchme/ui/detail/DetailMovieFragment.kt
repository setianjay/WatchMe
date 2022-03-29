package com.setianjay.watchme.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.setianjay.watchme.R
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.databinding.FragmentDetailMovieBinding
import com.setianjay.watchme.utils.FormatUtil
import com.setianjay.watchme.utils.ViewUtil.load
import timber.log.Timber

class DetailMovieFragment : BaseFragment() {
    private var _binding: FragmentDetailMovieBinding? = null
    private val binding get() = _binding

    private val detailViewModel by viewModels<DetailViewModel> {
        movieViewModelFactory
    }

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
     * show detail movie
     * */
    private fun showDetailMovie() {
        val movieId: Long

        //get data from safeargs
        DetailMovieFragmentArgs.fromBundle(arguments as Bundle).apply {
            movieId = this.movieId
        }

        //get observer for detail movie based on movie id and is movies value
        observe(movieId)
    }

    /**
     * to obtain data from observer
     *
     * @param movieId       id of movie
     * */
    private fun observe(movieId: Long) {
        detailViewModel.getMovieDetail(movieId).observe(viewLifecycleOwner) { response ->
            Timber.d("observe movie run")
            populateData(response)
        }
    }

    /**
     * populate data to screen
     *
     * @param detailMovie       data of detail movie
     * */
    private fun populateData(detailMovie: MovieEntity) {
        val imageBookmark =
            if (detailMovie.isFavorite) R.drawable.ic_bookmark_selected else R.drawable.ic_bookmark_not_selected

        binding?.apply {
            ivPoster.load(detailMovie.poster)
            tvTitle.text = detailMovie.title
            tvGenre.text = FormatUtil.genreFormat(detailMovie.genre)
            tvRelease.text =
                resources.getString(R.string.release, FormatUtil.dateFormat(detailMovie.release))
            rating.rating = detailMovie.rating
            tvRating.text = "${detailMovie.rating}"
            tvOverview.text = detailMovie.overview
            ivBookmark.setImageResource(imageBookmark)
        }

        //set movie to favorite
        binding?.ivBookmark?.setOnClickListener {
            detailViewModel.setFavorite(detailMovie)
            if (detailMovie.isFavorite) {
                Toast.makeText(
                    requireContext(),
                    requireContext().getString(R.string.add_favorite),
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    requireContext(),
                    requireContext().getString(R.string.remove_favorite),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        //unbind fragment
        _binding = null
    }
}