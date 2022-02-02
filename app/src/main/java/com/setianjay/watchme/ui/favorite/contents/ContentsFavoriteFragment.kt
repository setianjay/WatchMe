package com.setianjay.watchme.ui.favorite.contents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.setianjay.watchme.R
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.databinding.FragmentContentsFavoriteBinding
import com.setianjay.watchme.ui.favorite.FavoriteFragmentDirections
import com.setianjay.watchme.ui.favorite.adapter.ContentsFavoriteAdapter
import com.setianjay.watchme.utils.ViewUtil.show
import timber.log.Timber

class ContentsFavoriteFragment private constructor() : BaseFragment(),
    ContentsFavoriteAdapter.IOnContentsFavoriteAdapterListener {
    private var _binding: FragmentContentsFavoriteBinding? = null
    private val binding get() = _binding

    private lateinit var contentsFavoriteAdapter: ContentsFavoriteAdapter

    private val contentsFavoriteViewModel by viewModels<ContentsFavoriteViewModel> {
        movieViewModelFactory
    }

    private var isMovies: Boolean? = null

    override fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContentsFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {
        itemTouchHelper.attachToRecyclerView(binding?.rvFavorite)
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
        contentsFavoriteAdapter = ContentsFavoriteAdapter(requireContext(), this)

        //get observer for content based on parameter
        observer(isMovies, contentsFavoriteAdapter)

        binding?.rvFavorite?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = contentsFavoriteAdapter
            setHasFixedSize(true)
        }
    }

    /**
     * to obtain data from observer
     *
     * @param isMovies      if true the data is movie popular, otherwise tv popular
     * */
    private fun observer(isMovies: Boolean, adapter: ContentsFavoriteAdapter) {
        if (isMovies) {
            contentsFavoriteViewModel.getAllMovieBookmarked()
                .observe(viewLifecycleOwner) { response ->
                    if (response.isNotEmpty()) {
                        showImageInformation(false)
                        showRecycleView(true)
                        adapter.submitList(response)
                        Timber.d("favorite movie : $response")
                    } else {
                        showImageInformation(true)
                        showRecycleView(false)
                    }
                }
        } else {
            contentsFavoriteViewModel.getAllTvMovieBookmarked()
                .observe(viewLifecycleOwner) { response ->
                    if (response.isNotEmpty()) {
                        showImageInformation(false)
                        showRecycleView(true)
                        adapter.submitList(response)
                        Timber.d("favorite tv : $response")
                    } else {
                        showImageInformation(true)
                        showRecycleView(false)
                    }
                }
        }
    }

    /**
     * to show image information if no data in favorite
     *
     * @param show      true for appears, otherwise disappears
     * */
    private fun showImageInformation(show: Boolean) {
        binding?.apply {
            ivInformation.show(show)
            tvTitle.show(show)
            tvMessage.show(show)

        }
    }

    /**
     * to show recycle view if have data in favorite
     *
     * @param show      true for appears, otherwise disappears
     * */
    private fun showRecycleView(show: Boolean) {
        binding?.rvFavorite?.show(show)
    }

    /**
     * when one of item in favorite list has clicked, move them to DetailMovieFragment
     *
     * @param movieId id of movie
     *
     * note: this event listener from [ContentsFavoriteAdapter.IOnContentsFavoriteAdapterListener]
     * */
    override fun onClickItem(movieId: Long) {
        //send movie id and state of movie to DetailMovieFragment through SafeArgs
        val favoriteToDetail = FavoriteFragmentDirections.actionFavoriteFragmentToDetailMovieFragment(
            movieId
        )

        //move from favorite fragment to detail
        findNavController().navigate(favoriteToDetail)
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = contentsFavoriteAdapter.getSwipedData(swipedPosition)

                //change status favorite
                movieEntity?.let { contentsFavoriteViewModel.setFavorite(it) }
                Toast.makeText(requireContext(), getString(R.string.remove_favorite), Toast.LENGTH_SHORT).show()
            }
        }
    })

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val ARG_IS_MOVIES = "is_movies"

        fun getInstance(isMovies: Boolean): ContentsFavoriteFragment {
            val bundle = Bundle().apply {
                putBoolean(ARG_IS_MOVIES, isMovies)
            }

            return ContentsFavoriteFragment().apply {
                arguments = bundle
            }
        }
    }
}