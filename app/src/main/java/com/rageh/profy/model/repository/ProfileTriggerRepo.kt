package com.rageh.profy.model.repository

import com.rageh.profy.model.databse.dao.ProfileTriggerDao
import com.rageh.profy.model.entity.ProfileTrigger
import com.rageh.profy.model.repository.base.BaseRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileTriggerRepo @Inject constructor(private val profileTriggerDao: ProfileTriggerDao) :
    BaseRepo<ProfileTrigger>(profileTriggerDao) {

    fun getProfileTrigger(triggerId: Long) = profileTriggerDao.getProfileTrigger(triggerId)

    fun getProfileTriggers(@ProfileTrigger.TriggerType type: Int) =
        profileTriggerDao.getAllProfileTriggers()

    fun getAllProfileTriggers() =
        profileTriggerDao.getAllProfileTriggers()
}