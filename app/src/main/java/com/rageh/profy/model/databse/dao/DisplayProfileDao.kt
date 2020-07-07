package com.rageh.profy.model.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.model.databse.dao.base.BaseDao
import com.rageh.profy.model.entity.DisplayProfile

@Dao
interface DisplayProfileDao : BaseDao<DisplayProfile> {

    @Query("SELECT * FROM display_profiles WHERE id=:profileId")
    fun getDisplayProfile(profileId: Long): LiveData<DisplayProfile>

    @Query("SELECT * FROM display_profiles")
    fun getAllDisplayProfiles(): LiveData<List<DisplayProfile>>
}