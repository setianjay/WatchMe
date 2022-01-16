package com.setianjay.watchme.data.source.remote.retrofit

import com.setianjay.watchme.data.source.remote.constant.RemoteConst
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieDbApiBuilder {

    /**
     * obtain endpoint of movie db API
     *
     * @return      endpoint of movie db API
     * */
    fun getApiService(): MovieDbEndpoint{
        val interceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(RemoteConst.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(MovieDbEndpoint::class.java)
    }

}