package com.rageh.profy.domain.profile

import com.rageh.profy.data.entity.FullUserProfile
import com.rageh.profy.data.repository.UserProfilesRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProfileHandler @Inject constructor(
    private val userProfilesRepo: UserProfilesRepo,
    private val audioProfileHandler: AudioProfileHandler
) {

    fun activateProfile(profile: FullUserProfile) {
        profile.audioProfile?.let {
            audioProfileHandler.setCurrentProfile(it)
        }
    }
}