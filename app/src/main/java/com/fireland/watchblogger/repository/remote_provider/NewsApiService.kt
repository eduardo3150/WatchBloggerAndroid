package com.fireland.watchblogger.repository.remote_provider

import com.fireland.watchblogger.models.WatchArticlesResponse
import javax.inject.Inject

interface NewsApiService {
    suspend fun getLatestWatchNews(): WatchArticlesResponse
}

class NewsApiServiceImpl @Inject constructor() : NewsApiService {
    private val endpointService = EndpointFactory.makeHttpService()

    override suspend fun getLatestWatchNews() =
        endpointService.getWatchArticles(date = "2020-12-17")
}