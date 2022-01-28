package com.setianjay.watchme.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.setianjay.watchme.R
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.databinding.FragmentDetailMovieBinding
import com.setianjay.watchme.utils.DataDummyUtil
import com.setianjay.watchme.utils.FormatUtil
import com.setianjay.watchme.utils.ViewUtil.load
import com.setianjay.watchme.utils.ViewUtil.show
import timber.log.Timber

class DetailMovieFragment : BaseFragment() {
    private var _binding: FragmentDetailMovieBinding? = null
    private val binding get() = _binding

    private val detailViewModel by viewModels<DetailViewModel>{
        movieViewModelFactory
    }

    private var detailMovie: MovieEntity? = null

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
        val isMovies: Boolean

        //get data from safeargs
        DetailMovieFragmentArgs.fromBundle(arguments as Bundle).apply {
            movieId = this.movieId
            isMovies = this.isMovies
        }

        //get observer for detail movie based on movie id and is movies value
        observe(movieId, isMovies)
        Timber.d("overview: ${DataDummyUtil.generateDataTvShows()[0].overview}")
    }

    /**
     * to obtain data from observer
     *
     * @param movieId       id of movie
     * @param isMovies      if true the data is detail of movie popular, otherwise detail of tv popular
     * */
    private fun observe(movieId: Long, isMovies: Boolean){
        if (isMovies){
            detailViewModel.getMovieDetail(movieId).observe(viewLifecycleOwner){ response ->
                when(response.statusType){
                    Resource.StatusType.LOADING -> {
                        binding?.pbLoading?.show(true)
                        binding?.parentDetailContent?.show(false)
                    }
                    Resource.StatusType.SUCCESS -> {
                        binding?.pbLoading?.show(false)
                        binding?.parentDetailContent?.show(true)
                        detailMovie = response?.data
                        detailMovie?.let { populateData(it) }
                    }
                    Resource.StatusType.ERROR -> {
                        binding?.pbLoading?.show(false)
                    }
                }
            }
        }else{
            detailViewModel.getTvDetail(movieId).observe(viewLifecycleOwner){ response ->
                when(response.statusType){
                    Resource.StatusType.LOADING -> {
                        binding?.pbLoading?.show(true)
                        binding?.parentDetailContent?.show(false)
                    }
                    Resource.StatusType.SUCCESS -> {
                        binding?.pbLoading?.show(false)
                        binding?.parentDetailContent?.show(true)
                        detailMovie = response?.data
                        detailMovie?.let { populateData(it) }
                    }
                    Resource.StatusType.ERROR -> {
                        binding?.pbLoading?.show(false)
                    }
                }
            }
        }
    }

    /**
     * populate data to screen
     *
     * @param detailMovie       data of detail movie
     * */
    private fun populateData(detailMovie: MovieEntity){
        Timber.d("overview response: ${detailMovie.overview}")
        binding?.apply {
            ivPoster.load(detailMovie.poster)
            tvTitle.text = detailMovie.title
            tvGenre.text = FormatUtil.genreFormat(detailMovie.genre)
            tvRelease.text = resources.getString(R.string.release, FormatUtil.dateFormat(detailMovie.release))
            rating.rating = detailMovie.rating
            tvRating.text = "${detailMovie.rating}"
            tvOverview.text = detailMovie.overview
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