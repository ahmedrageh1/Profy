package com.rageh.profy.model.databse.dao

import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.model.databse.dao.base.BaseDao
import com.rageh.profy.model.entity.AudioProfile

/**
 * Created by Ahmed on 2/27/2019.
 */
@Dao
interface AudioProfileDao : BaseDao<AudioProfile> {

    @Query("SELECT * FROM audio_profiles")
    fun getAudioProfile(): AudioProfile

}