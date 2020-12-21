package com.fireland.watchblogger.repository.local_provider

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fireland.watchblogger.models.UserArticle

@Dao
interface UserArticleDao {
    @Query("SELECT * FROM UserArticle")
    fun getAll(): List<UserArticle>

    @Query("SELECT * FROM UserArticle WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserArticle>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): UserArticle

    @Insert
    fun insertAll(vararg users: UserArticle)

    @Delete
    fun delete(user: UserArticle)
}