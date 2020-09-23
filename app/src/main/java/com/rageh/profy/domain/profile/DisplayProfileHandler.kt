package com.rageh.profy.domain.profile

import com.rageh.profy.data.entity.DisplayProfile
import com.rageh.profy.util.DisplayUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DisplayProfileHandler @Inject constructor(private val displayUtils: DisplayUtils) {

    fun getCurrentProfile() = displayUtils.run {
        DisplayProfile(
            screenBrightnessMode = displayUtils.getDisplayBrightnessMode(),
            screenBrightness = displayUtils.getDisplayBrightness(),
            screenOffTimeout = displayUtils.getScreenOffTimeout()
        )
    }

    fun setCurrentProfile(displayProfile: DisplayProfile) = displayUtils.run {
        setDisplayBrightnessMode(displayProfile.screenBrightnessMode)
        setDisplayBrightness(displayProfile.screenBrightness)
        setScreenOffTimeout(displayProfile.screenOffTimeout)
    }

    fun getMaxLevelsProfile() = displayUtils.run {
        DisplayProfile(
            screenBrightnessMode = displayUtils.getDisplayBrightnessMode(),
            screenBrightness = displayUtils.getMaxDisplayBrightness(),
            screenOffTimeout = displayUtils.getScreenOffTimeout()
        )
    }
}