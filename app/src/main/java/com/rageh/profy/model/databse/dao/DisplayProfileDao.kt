package com.rageh.profy.model.databse.dao

import androidx.room.*
import com.rageh.profy.model.entity.DisplayProfile

/**
 * Created by Ahmed on 3/2/2019.
 */
@Dao
interface DisplayProfileDao {
    @Insert
    fun insert(displayProfile: DisplayProfile)

    @Update
    fun update(displayProfile: DisplayProfile)

    @Delete
    fun delete(displayProfile: DisplayProfile)

    @Query("SELECT * FROM display_profiles where user_profile_id=:userProfileId")
    fun getAudioProfile(userProfileId: Int)
}