package com.rageh.profy.data.repository

import com.rageh.profy.data.databse.dao.UserProfileDao
import com.rageh.profy.data.entity.UserProfile
import com.rageh.profy.data.repository.base.BaseRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProfilesRepo @Inject constructor(private val userProfileDao: UserProfileDao) :
    BaseRepo<UserProfile>(userProfileDao) {
    fun getAllUserProfiles() =
        userProfileDao.getAllFullProfiles()

    fun getDefaultUserProfile() = userProfileDao.getDefaultProfile()

    fun getFullUserProfile(profileId: Long) = userProfileDao.getFullProfile(profileId)
}