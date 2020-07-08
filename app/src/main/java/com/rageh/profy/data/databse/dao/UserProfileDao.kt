package com.rageh.profy.data.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.data.databse.dao.base.BaseDao
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
}