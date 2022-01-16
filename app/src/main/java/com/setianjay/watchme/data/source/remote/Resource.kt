package com.setianjay.watchme.data.source.remote

class Resource<T>(val statusType: StatusType, val data: T?, val message: Int?) {
    enum class StatusType {
        LOADING,
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> loading(): Resource<T> {
            return Resource(StatusType.LOADING, null, null)
        }

        fun <T> success(data: T?): Resource<T>{
            return Resource(StatusType.SUCCESS, data, null )
        }

        fun <T> error(message: Int): Resource<T>{
            return Resource(StatusType.ERROR, null, message)
        }
    }
}