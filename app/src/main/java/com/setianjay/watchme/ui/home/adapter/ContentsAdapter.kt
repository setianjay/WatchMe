package com.setianjay.watchme.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.setianjay.watchme.R
import com.setianjay.watchme.databinding.ItemListContentBinding
import com.setianjay.watchme.model.Movies
import com.setianjay.watchme.utils.ViewUtil.load

class ContentsAdapter(
    private val context: Context,
    private val listener: IOnContentsAdapterListener
) : RecyclerView.Adapter<ContentsAdapter.ViewHolder>() {
    private val contents: ArrayList<Movies> = ArrayList()

    fun setContents(contents: List<Movies>) {
        this.contents.apply {
            clear()
            addAll(contents)
        }
        notifyDataSetChanged()
    }

    interface IOnContentsAdapterListener {
        fun onClickItem(position: Int)
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
        fun bind(movie: Movies) {
            binding.apply {
                tvTitle.text = movie.title
                rating.rating = movie.rating
                tvRating.text = "${movie.rating}"
                tvGenre.text = movie.genre.joinToString(",", postfix = " ")
                tvDuration.text = context.getString(R.string.duration, movie.duration)

                ivPoster.load(movie.poster)

                root.setOnClickListener {
                    listener.onClickItem(adapterPosition)
                }
            }
        }
    }
}