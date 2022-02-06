package com.setianjay.watchme.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.setianjay.watchme.data.source.remote.constant.RemoteConst

object ViewUtil {

    /**
     * hide keyboard
     *
     * @param view          view
     **/
    fun Context.hideKeyboard(view: View){
        val imm: InputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

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