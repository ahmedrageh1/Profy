package com.rageh.profy.domain.profile

import com.rageh.profy.data.entity.FullUserProfile
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FullProfileHandler @Inject constructor(private val audioProfileHandler: AudioProfileHandler) {

    fun activateProfile(profile: FullUserProfile) {
        profile.audioProfile?.let {
            audioProfileHandler.setCurrentProfile(it)
        }
    }
}