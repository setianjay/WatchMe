package com.setianjay.watchme.data.source.remote

class ApiResponse<T> private constructor(
    val statusResponse: StatusResponse,
    val body: T,
    val message: String?
) {
    companion object{
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(StatusResponse.SUCCESS, body, null)

        fun <T> error(msg: String, body: T): ApiResponse<T> = ApiResponse(StatusResponse.ERROR, body, msg)
    }
}