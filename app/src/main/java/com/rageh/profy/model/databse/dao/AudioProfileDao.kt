package com.rageh.profy.model.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.model.databse.dao.base.BaseDao
import com.rageh.profy.model.entity.AudioProfile

/**
 * Created by Ahmed on 2/27/2019.
 */
@Dao
interface AudioProfileDao : BaseDao<AudioProfile> {

    @Query("SELECT * FROM audio_profiles WHERE id=:profileId")
    fun getAudioProfile(profileId: Long): LiveData<AudioProfile>

    @Query("SELECT * FROM audio_profiles")
    fun getAllAudioProfiles(): LiveData<List<AudioProfile>>

}