package com.rageh.profy.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.rageh.profy.data.entity.AudioProfile

/**
 * Created by Ahmed on 2/27/2019.
 */
@Dao
interface AudioProfileDao {

    @Insert
    fun insert(audioProfile: AudioProfile)

    @Update
    fun update(audioProfile: AudioProfile)

    @Delete
    fun delete(audioProfile: AudioProfile)
}