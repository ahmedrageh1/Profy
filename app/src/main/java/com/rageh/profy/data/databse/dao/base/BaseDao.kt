package com.rageh.profy.data.databse.dao.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    suspend fun insert(item: T): Long

    @Update
    suspend fun update(item: T)

    @Delete
    suspend fun delete(item: T)

}