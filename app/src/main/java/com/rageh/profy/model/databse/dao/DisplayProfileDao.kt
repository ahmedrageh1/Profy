package com.rageh.profy.model.databse.dao

import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.model.databse.dao.base.BaseDao
import com.rageh.profy.model.entity.DisplayProfile

/**
 * Created by Ahmed on 3/2/2019.
 */
@Dao
interface DisplayProfileDao : BaseDao<DisplayProfile> {

    @Query("SELECT * FROM display_profiles")
    fun getDisplayProfile(): DisplayProfile
}