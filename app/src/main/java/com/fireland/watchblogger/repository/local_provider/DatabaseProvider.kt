package com.fireland.watchblogger.repository.local_provider

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext

interface DatabaseProvider {

}

class DatabaseProviderImpl constructor(@ApplicationContext private val applicationContext: Context) :
    DatabaseProvider {

    fun getDb(): UserArticleDatabase {
        return Room.databaseBuilder(
            applicationContext,
            UserArticleDatabase::class.java, "database-name"
        ).build()
    }
}