package com.rageh.profy.data.repository

import com.rageh.profy.data.databse.dao.DisplayProfileDao
import com.rageh.profy.data.entity.DisplayProfile
import com.rageh.profy.data.repository.base.BaseRepo
import com.rageh.profy.util.DisplayUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DisplayProfilesRepo @Inject constructor(
    private val displayProfileDao: DisplayProfileDao,
    private val displayUtils: DisplayUtils
) :
    BaseRepo<DisplayProfile>(displayProfileDao) {

    fun getCurrentProfile() = displayUtils.run {
        DisplayProfile(
            screenAutoBrightness = displayUtils.isDisplayAutoBrightness(),
            screenBrightness = displayUtils.getDisplayBrightness(),
            screenOffTimeout = displayUtils.getScreenOffTimeout(),
            screenAutoRotation = displayUtils.isAutoRotationEnabled()
        )
    }

    fun getDisplayProfile(profileId: Long) = displayProfileDao.getDisplayProfile(profileId)

    fun getAllDisplayProfiles() =
        displayProfileDao.getAllDisplayProfiles()
}