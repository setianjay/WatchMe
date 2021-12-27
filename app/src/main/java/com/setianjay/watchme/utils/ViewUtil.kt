package com.setianjay.watchme.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

object ViewUtil {

    /**
     * Image loader
     * */
    fun ImageView.load(idRes: Int){
        Glide.with(this.context)
            .load(idRes)
            .into(this)
    }
}