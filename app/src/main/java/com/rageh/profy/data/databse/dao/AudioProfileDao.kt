package com.rageh.profy.data.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.data.databse.dao.base.BaseDao
import com.rageh.profy.data.entity.AudioProfile
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ahmed on 2/27/2019.
 */
@Dao
interface AudioProfileDao : BaseDao<AudioProfile> {

    @Query("SELECT * FROM audio_profiles WHERE id=:profileId")
    fun getAudioProfile(profileId: Long): Flow<AudioProfile>

    @Query("SELECT * FROM audio_profiles")
    fun getAllAudioProfiles(): Flow<List<AudioProfile>>

}