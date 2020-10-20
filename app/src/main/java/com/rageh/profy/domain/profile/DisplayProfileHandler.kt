package com.rageh.profy.domain.profile

import com.rageh.profy.data.entity.DisplayProfile
import com.rageh.profy.data.repository.DisplayProfilesRepo
import com.rageh.profy.util.DisplayUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DisplayProfileHandler @Inject constructor(
    private val repo: DisplayProfilesRepo,
    private val displayUtils: DisplayUtils
) {

    fun getCurrentProfile() = repo.getCurrentProfile()

    fun applyProfile(displayProfile: DisplayProfile) = displayUtils.run {
        setDisplayBrightness(displayProfile.screenBrightness)
        setDisplayAutoBrightnessEnabled(displayProfile.screenAutoBrightness)
        setScreenOffTimeout(displayProfile.screenOffTimeout)
        setAutoRotationEnabled(displayProfile.screenAutoRotation)
    }

    fun getAllDisplayProfiles() = repo.getAllDisplayProfiles()

    fun insert(displayProfile: DisplayProfile) = repo.insertLive(displayProfile)


}