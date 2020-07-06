package com.rageh.profy.model.repository

import androidx.lifecycle.LiveData
import com.rageh.profy.model.databse.dao.UserProfileDao
import com.rageh.profy.model.entity.UserProfile
import com.rageh.profy.model.repository.base.BaseRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProfilesRepo @Inject constructor(private val userProfileDao: UserProfileDao) :
    BaseRepo<UserProfile>(userProfileDao) {
    fun getAllUserProfiles(): LiveData<List<UserProfile>> =
        userProfileDao.getAllProfiles()
}