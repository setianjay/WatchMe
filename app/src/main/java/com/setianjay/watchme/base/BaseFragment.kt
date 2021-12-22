package com.setianjay.watchme.base

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.setianjay.watchme.ui.MainActivity

abstract class BaseFragment: Fragment() {
    protected lateinit var runOnUiThread: Handler

    /**
     * init all initialization for fragment in here
     * */
    abstract fun onBindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?

    /**
     * bind view of fragment
     *
     * @return parent or view group from layout fragment
     * */
    abstract fun init()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        runOnUiThread = (requireActivity() as MainActivity).mHandler
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return onBindView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
    }
}