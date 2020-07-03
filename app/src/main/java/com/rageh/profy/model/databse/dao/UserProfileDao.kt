package com.rageh.profy.model.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rageh.profy.model.entity.UserProfile

/**
 * Created by Ahmed on 3/2/2019.
 */
@Dao
interface UserProfileDao {

    @Insert
    fun insert(userProfile: UserProfile)

    @Update
    fun update(userProfile: UserProfile)

    @Delete
    fun delete(userProfile: UserProfile)

    @Query("SELECT * FROM user_profiles where id=:profileId")
    fun getProfile(profileId: Int): UserProfile

    @Query("SELECT * FROM user_profiles")
    fun getAllProfiles(): LiveData<List<UserProfile>>
}