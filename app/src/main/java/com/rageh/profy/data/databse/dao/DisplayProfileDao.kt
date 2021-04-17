package com.rageh.profy.data.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.data.databse.dao.base.BaseDao
import com.rageh.profy.data.entity.DisplayProfile
import kotlinx.coroutines.flow.Flow

@Dao
interface DisplayProfileDao : BaseDao<DisplayProfile> {

    @Query("SELECT * FROM display_profiles WHERE id=:profileId")
    fun getDisplayProfile(profileId: Long): Flow<DisplayProfile>

    @Query("SELECT * FROM display_profiles")
    fun getAllDisplayProfiles(): Flow<List<DisplayProfile>>
}