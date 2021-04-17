package com.rageh.profy.data.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.data.databse.dao.base.BaseDao
import com.rageh.profy.data.entity.ProfileTrigger
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileTriggerDao : BaseDao<ProfileTrigger> {

    @Query("SELECT * FROM profile_triggers WHERE id=:triggerId")
    fun getProfileTrigger(triggerId: Long): Flow<ProfileTrigger>

    @Query("SELECT * FROM profile_triggers WHERE type=:type")
    fun getProfileTriggersByType(@ProfileTrigger.TriggerType type: Int): Flow<List<ProfileTrigger>>

    @Query("SELECT * FROM profile_triggers")
    fun getAllProfileTriggers(): Flow<List<ProfileTrigger>>

}