package com.rageh.profy.data.databse.dao.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    fun insert(item: T): Long

    @Update
    fun update(item: T)

    @Delete
    fun delete(item: T)

}