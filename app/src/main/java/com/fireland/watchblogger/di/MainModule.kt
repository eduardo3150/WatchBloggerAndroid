package com.fireland.watchblogger.di

import com.fireland.watchblogger.network.NewsApiService
import com.fireland.watchblogger.network.NewsApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class MainModule {
    @Binds
    abstract fun bindNewsApiService(newsApiProviderImpl: NewsApiServiceImpl): NewsApiService
}