package com.setianjay.watchme.utils

import androidx.recyclerview.widget.DiffUtil
import com.setianjay.watchme.data.source.local.entity.MovieEntity

class MovieDiffCallback(
    private val oldItems: List<MovieEntity>,
    private val newItems: List<MovieEntity>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].movieId == newItems[newItemPosition].movieId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].title == newItems[newItemPosition].title && oldItems[oldItemPosition].overview == newItems[newItemPosition].overview

}