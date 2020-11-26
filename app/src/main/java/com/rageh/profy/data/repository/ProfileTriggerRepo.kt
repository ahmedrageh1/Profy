package com.rageh.profy.data.repository

import com.rageh.profy.data.databse.dao.ProfileTriggerDao
import com.rageh.profy.data.entity.ProfileTrigger
import com.rageh.profy.data.repository.base.BaseRepo
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileTriggerRepo @Inject constructor(private val profileTriggerDao: ProfileTriggerDao) :
    BaseRepo<ProfileTrigger>(profileTriggerDao) {

    fun createTimeTrigger() = ProfileTrigger(
        type = ProfileTrigger.TRIGGER_TYPE_TIME,
        time = Date()
    )

    fun getProfileTrigger(triggerId: Long) = profileTriggerDao.getProfileTrigger(triggerId)

    fun getProfileTriggers(@ProfileTrigger.TriggerType type: Int) =
        profileTriggerDao.getAllProfileTriggers()

    fun getAllProfileTriggers() =
        profileTriggerDao.getAllProfileTriggers()
}