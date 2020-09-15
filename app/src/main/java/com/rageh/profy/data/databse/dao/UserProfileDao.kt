package com.rageh.profy.data.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.rageh.profy.data.databse.dao.base.BaseDao
import com.rageh.profy.data.entity.FullUserProfile
import com.rageh.profy.data.entity.UserProfile

/**
 * Created by Ahmed on 3/2/2019.
 */
@Dao
interface UserProfileDao : BaseDao<UserProfile> {

    @Query("SELECT * FROM user_profiles where id=:profileId")
    fun getProfile(profileId: Int): LiveData<UserProfile>

    @Query("SELECT * FROM user_profiles")
    fun getAllProfiles(): LiveData<List<UserProfile>>

    @Transaction
    @Query("SELECT * FROM user_profiles where id=:profileId")
    fun getFullProfile(profileId: Int): LiveData<FullUserProfile>

    @Transaction
    @Query("SELECT * FROM user_profiles ORDER BY id ASC LIMIT 1")
    fun getDefaultProfile(): LiveData<UserProfile>

    @Transaction
    @Query("SELECT * FROM user_profiles")
    fun getAllFullProfiles(): LiveData<List<FullUserProfile>>
}