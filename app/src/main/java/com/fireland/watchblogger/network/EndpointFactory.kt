package com.fireland.watchblogger.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object EndpointFactory {
    private const val BASE_FINAL_URL = "https://newsapi.org/v2/"
    private const val API_KEY = "fabd60c0bee54a74bd4622c1d0534c41"

    fun makeHttpService(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_FINAL_URL)
            .client(getNoAuthHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    private fun getNoAuthHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getApiKeyInterceptor())
            .addInterceptor(getLoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }


    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    private fun getApiKeyInterceptor(): Interceptor {
        return Interceptor {
            var request = it.request()
            val url = request
                .url()
                .newBuilder()
                .addQueryParameter("apiKey", API_KEY)
                .build()

            request = request
                .newBuilder()
                .url(url)
                .build()
            it.proceed(request)
        }
    }
}