package com.rageh.profy.data.repository

import androidx.lifecycle.LiveData
import com.rageh.profy.data.databse.dao.UserProfileDao
import com.rageh.profy.data.entity.UserProfile
import com.rageh.profy.data.repository.base.BaseRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProfilesRepo @Inject constructor(private val userProfileDao: UserProfileDao) :
    BaseRepo<UserProfile>(userProfileDao) {
    fun getAllUserProfiles(): LiveData<List<UserProfile>> =
        userProfileDao.getAllProfiles()
}