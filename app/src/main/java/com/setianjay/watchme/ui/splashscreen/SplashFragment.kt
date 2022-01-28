package com.setianjay.watchme.ui.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.setianjay.watchme.R
import com.setianjay.watchme.base.BaseFragment
import com.setianjay.watchme.databinding.FragmentSplashBinding
import com.setianjay.watchme.utils.AnimationUtil
import com.setianjay.watchme.utils.EspressoIdlingResources
import kotlinx.coroutines.*


class SplashFragment : BaseFragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding

    override fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {
        setupAnimations()
        showProgressLoading()
    }

    /**
     * setup animation for view who need animation
     * */
    private fun setupAnimations() {
        AnimationUtil.topToBottom(requireContext()).let {
            binding?.apply {
                titleOne.startAnimation(it)
                titleTwo.startAnimation(it)
                titleThree.startAnimation(it)
                subtitleOne.startAnimation(it)
                subtitleTwo.startAnimation(it)
            }
        }
    }

    /**
     * process loading on splash before move to next layout
     *
     * @thread background thread, main thread
     * */
    private fun showProgressLoading() {
        CoroutineScope(Dispatchers.Default).launch {
            val maxCounter = 100
            EspressoIdlingResources.increment()
            for (i in 0..100 step 2) {
                withContext(Dispatchers.Main) {
                    delay(90L)
                    binding?.apply {
                        pbHorizontal.progress = i
                        pbHorizontal.max = maxCounter
                        tvPercentage.text = resources.getString(R.string.percentage, i)
                    }
                    if (i == maxCounter) {
                        //move to other fragment
                            if (!EspressoIdlingResources.idlingResource.isIdleNow){
                                EspressoIdlingResources.decrement()
                            }
                        findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                    }
                }
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        //unbind fragment
        _binding = null
    }
}