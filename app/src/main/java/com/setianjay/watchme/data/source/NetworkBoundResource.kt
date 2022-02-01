package com.setianjay.watchme.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.setianjay.watchme.data.source.remote.ApiResponse
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.data.source.remote.StatusResponse
import com.setianjay.watchme.utils.BackgroundUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class NetworkBoundResource<RESULT_TYPE, REQUEST_TYPE> {

    //coroutine for running background task
    private val coroutineScope = BackgroundUtil.coroutineScope

    private val result: MediatorLiveData<Resource<RESULT_TYPE>> = MediatorLiveData()

    init {
        result.value = Resource.loading()

        @Suppress("LeakingThis")
        val dbSource = loadFromDb()

        result.addSource(dbSource){ data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)){
                fetchFromNetwork(dbSource)
            }else{
                result.addSource(dbSource){ newData ->
                    result.value = Resource.success(newData)
                }
            }
        }
    }

    protected abstract fun loadFromDb(): LiveData<RESULT_TYPE>

    protected abstract fun shouldFetch(data: RESULT_TYPE?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<REQUEST_TYPE>>

    protected abstract fun saveCallResult(data: REQUEST_TYPE)

    private fun fetchFromNetwork(dbSource: LiveData<RESULT_TYPE>){
        val apiResponse = createCall()

        result.addSource(dbSource){
            result.value = Resource.loading()
        }

        result.addSource(apiResponse){ response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)

            when(response.statusResponse){
                StatusResponse.SUCCESS -> {
                    coroutineScope.launch {
                        saveCallResult(response.body)
                        withContext(Dispatchers.Main) {
                            result.addSource(dbSource){ newData ->
                                result.value = Resource.success(newData)
                            }
                        }
                    }
                }
                StatusResponse.ERROR -> {
                    result.addSource(dbSource){
                        result.value = Resource.error(response.message as String)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<RESULT_TYPE>> = result
}