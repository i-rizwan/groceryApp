package com.necto.fruitgroceryapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    private fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return client
    }

    private fun useRetrofit(baseUrl: String): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit
    }

    //fun useService(): NetworkHelper = useRetrofit().create(NetworkHelper::class.java)
    fun useService(baseUrl: String): ApiService {
        return useRetrofit(baseUrl).create(ApiService::class.java)
    }
}
