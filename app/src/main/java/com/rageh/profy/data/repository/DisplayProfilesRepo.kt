package com.rageh.profy.data.repository

import com.rageh.profy.data.databse.dao.DisplayProfileDao
import com.rageh.profy.data.entity.DisplayProfile
import com.rageh.profy.data.repository.base.BaseRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DisplayProfilesRepo @Inject constructor(private val displayProfileDao: DisplayProfileDao) :
    BaseRepo<DisplayProfile>(displayProfileDao) {

    fun getDisplayProfile(profileId: Long) = displayProfileDao.getDisplayProfile(profileId)

    fun getAllDisplayProfiles() =
        displayProfileDao.getAllDisplayProfiles()
}