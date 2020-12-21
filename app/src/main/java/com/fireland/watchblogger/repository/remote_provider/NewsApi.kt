package com.fireland.watchblogger.repository.remote_provider

import com.fireland.watchblogger.models.WatchArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getWatchArticles(
        @Query("q") query: String = "watches",
        @Query("from") date: String,
        @Query("sortBy") sortBy: String = "popularity",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: String = "20",
    ): WatchArticlesResponse
}