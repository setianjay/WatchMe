package com.setianjay.watchme.ui.home.adapter

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

class ContentsAdapter(
    private val context: Context,
    private val listener: IOnContentsAdapterListener
) : RecyclerView.Adapter<ContentsAdapter.ViewHolder>() {
    private val contents: ArrayList<MovieEntity> = ArrayList()

    fun setContents(contents: List<MovieEntity>) {
        val diffUtil = MovieDiffCallback(this.contents, contents)
        val diffResult = DiffUtil.calculateDiff(diffUtil)

        this.contents.apply {
            clear()
            addAll(contents)
        }

        diffResult.dispatchUpdatesTo(this)
    }

    interface IOnContentsAdapterListener {
        fun onClickItem(movieId: Long)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = contents[position]
        holder.bind(content)
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    inner class ViewHolder(private val binding: ItemListContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            binding.apply {
                tvTitle.text = movie.title
                rating.rating = movie.rating
                tvRating.text = "${movie.rating}"
                tvGenre.text = FormatUtil.genreFormat(movie.genre)
                tvRelease.text = context.getString(R.string.release, FormatUtil.dateFormat(movie.release))

                ivPoster.load(movie.poster)

                root.setOnClickListener {
                    listener.onClickItem(movie.movieId)
                }
            }
        }
    }
}