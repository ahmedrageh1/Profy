package com.rageh.profy.model.databse.dao

import androidx.room.*
import com.rageh.profy.model.entity.AudioProfile

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

    @Query("SELECT * FROM audio_profiles where user_profile_id=:userProfileId")
    fun getAudioProfile(userProfileId: Int)
}