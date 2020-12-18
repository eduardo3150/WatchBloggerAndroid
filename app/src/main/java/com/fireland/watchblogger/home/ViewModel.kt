package com.fireland.watchblogger.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.fireland.watchblogger.helpers.Resource
import com.fireland.watchblogger.network.NewsApiService
import kotlinx.coroutines.Dispatchers

class ViewModel @ViewModelInject constructor(private val newsApiService: NewsApiService) :
    ViewModel() {
    fun getLatestWatchNews() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = newsApiService.getLatestWatchNews()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}