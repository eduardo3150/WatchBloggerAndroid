package com.fireland.watchblogger.repository.local_provider

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fireland.watchblogger.models.UserArticle

@Database(entities = [UserArticle::class], version = 1)
abstract class UserArticleDatabase : RoomDatabase() {
    abstract fun userArticle(): UserArticleDao
}