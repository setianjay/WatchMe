package com.setianjay.watchme.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.setianjay.watchme.data.source.remote.constant.RemoteConst

object ViewUtil {

    /**
     * Image loader with glide
     *
     * @param poster        filename of poster on url
     * */
    fun ImageView.load(poster: String){
        Glide.with(this.context)
            .load(RemoteConst.POSTER_PATH + poster)
            .into(this)
    }

    /**
     * handle of visibility progress bar
     *
     * @param isShow        if true progress bar appears, otherwise disappears
     * */
    fun View.show(isShow: Boolean){
        this.visibility = if (isShow) View.VISIBLE else View.GONE
    }
}