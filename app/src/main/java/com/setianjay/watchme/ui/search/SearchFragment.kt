package com.setianjay.watchme.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.setianjay.watchme.R
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.databinding.FragmentSearchBinding
import com.setianjay.watchme.ui.search.adapter.SearchAdapter
import com.setianjay.watchme.utils.BackgroundUtil
import com.setianjay.watchme.utils.EspressoIdlingResources
import com.setianjay.watchme.utils.ViewUtil.hideKeyboard
import com.setianjay.watchme.utils.ViewUtil.show
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SearchFragment : BaseFragment(), SearchAdapter.IOnSearchAdapterListener {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding

    private lateinit var searchAdapter: SearchAdapter

    private val searchViewModel by viewModels<SearchViewModel> {
        movieViewModelFactory
    }

    override fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {
        searchMovie()
        setupRecycleView()
    }


    /**
     * function to handle search movie
     * */
    private fun searchMovie() {
        binding?.btnSearch?.setOnClickListener {
            val input = binding?.etSearch?.text.toString().trim()
            if (input.isEmpty()) {
                Toast.makeText(requireContext(), "Input search cannot be empty", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }
            //hide keyboard after finish input
            context?.hideKeyboard(requireView())

            //send input as arg
            observe("%$input%")
        }
    }

    /**
     * setup recycle view
     * */
    private fun setupRecycleView() {
        searchAdapter = SearchAdapter(requireContext(), this)

        binding?.rvResultSearch?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
            setHasFixedSize(true)
        }
    }

    /**
     * to obtain data from observer
     *
     * @param movieTitle       title of movie
     * */
    private fun observe(movieTitle: String) {
        searchViewModel.searchMovie(movieTitle).observe(viewLifecycleOwner) { response ->
            BackgroundUtil.coroutineScope.launch{
                EspressoIdlingResources.increment()
                withContext(Dispatchers.Main){
                    showImgInformation(false)
                    showLoading(true)
                    delay(2000L)
                    if (response.isNotEmpty()) {
                        showImgInformation(false)
                        showLoading(false)
                        showRecycleView(true)
                        searchAdapter.setResult(response)
                        EspressoIdlingResources.decrement()
                    } else {
                        showImgInformation(true, title = getString(R.string.movie_not_found))
                        showLoading(false)
                        showRecycleView(false)
                        EspressoIdlingResources.decrement()
                    }
                }
            }
        }
    }

    /**
     * to show image information if no data in search result
     *
     * @param show      true for appears, otherwise disappears
     * @param title     if title not empty, change value on tvTitle.text
     * */
    private fun showImgInformation(
        show: Boolean,
        title: String = ""
    ) {
        if (title.isNotEmpty()){
            binding?.apply {
                tvTitle.text = title
            }
        }

        binding?.apply {
            ivInformation.show(show)
            tvTitle.show(show)
            tvMessage.show(show)
        }
    }

    /**
     * to show loading process to waiting the result
     *
     * @param show      true for appears, otherwise disappears
     * */
    private fun showLoading(show: Boolean){
        binding?.pbLoading?.show(show)
    }

    /**
     * to show recycle view if there have data
     *
     * @param show      true for appears, otherwise disappears
     * */
    private fun showRecycleView(show: Boolean) {
        binding?.rvResultSearch?.show(show)
    }

    override fun onClickItem(movieId: Long) {
        //send movie id and state of movie to DetailMovieFragment through SafeArgs
        val searchToDetail = SearchFragmentDirections.actionSearchFragmentToDetailMovieFragment(
            movieId
        )

        //move from search fragment to detail
        findNavController().navigate(searchToDetail)
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