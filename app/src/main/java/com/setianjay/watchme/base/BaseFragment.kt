package com.setianjay.watchme.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.setianjay.watchme.utils.Injection
import com.setianjay.watchme.utils.MovieViewModelFactory

abstract class BaseFragment : Fragment() {
    protected val movieViewModelFactory get() =
        MovieViewModelFactory.getInstance(Injection.provideMovieRepository())

    /**
     * bind view of fragment
     *
     * @return parent or view group from layout fragment
     * */
    abstract fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?

    /**
     * init all initialization for fragment in here
     * */
    abstract fun init()

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