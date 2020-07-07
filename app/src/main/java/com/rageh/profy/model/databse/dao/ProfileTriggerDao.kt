package com.rageh.profy.model.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.model.databse.dao.base.BaseDao
import com.rageh.profy.model.entity.ProfileTrigger

@Dao
interface ProfileTriggerDao : BaseDao<ProfileTrigger> {

    @Query("SELECT * FROM profile_triggers WHERE id=:triggerId")
    fun getProfileTrigger(triggerId: Long): LiveData<ProfileTrigger>

    @Query("SELECT * FROM profile_triggers WHERE type=:type")
    fun getProfileTriggersByType(@ProfileTrigger.TriggerType type: Int): LiveData<List<ProfileTrigger>>

    @Query("SELECT * FROM profile_triggers")
    fun getAllProfileTriggers(): LiveData<List<ProfileTrigger>>

}