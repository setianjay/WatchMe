package com.setianjay.watchme.utils

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.setianjay.watchme.R

object AnimationUtil {

    fun topToBottom(context: Context): Animation{
        return AnimationUtils.loadAnimation(context, R.anim.top_to_bottom)
    }
}