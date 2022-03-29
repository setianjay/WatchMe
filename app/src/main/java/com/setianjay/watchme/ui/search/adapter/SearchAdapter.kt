package com.setianjay.watchme.ui.search.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.setianjay.watchme.R
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.databinding.ItemListContentBinding
import com.setianjay.watchme.utils.FormatUtil
import com.setianjay.watchme.utils.MovieDiffCallback
import com.setianjay.watchme.utils.ViewUtil.load

class SearchAdapter(private val context: Context, private val listener: IOnSearchAdapterListener) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    private val listResult: ArrayList<MovieEntity> = ArrayList()

    interface IOnSearchAdapterListener {

        fun onClickItem(movieId: Long)
    }

    fun setResult(listResult: List<MovieEntity>) {
        val diffSearchCallback = MovieDiffCallback(this.listResult, listResult)
        val diffResult = DiffUtil.calculateDiff(diffSearchCallback)

        this.listResult.clear()
        this.listResult.addAll(listResult)

        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        val binding =
            ItemListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.listResult.size
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        val result: MovieEntity = listResult[position]
        holder.bind(result)

    }

    inner class ViewHolder(private val binding: ItemListContentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieEntity) {
            binding.apply {
                tvTitle.text = movie.title
                rating.rating = movie.rating
                tvRating.text = "${movie.rating}"
                tvGenre.text = FormatUtil.genreFormat(movie.genre)
                tvRelease.text =
                    context.getString(R.string.release, FormatUtil.dateFormat(movie.release))

                ivPoster.load(movie.poster)

                root.setOnClickListener {
                    listener.onClickItem(movie.movieId)
                }
            }
        }

    }
}