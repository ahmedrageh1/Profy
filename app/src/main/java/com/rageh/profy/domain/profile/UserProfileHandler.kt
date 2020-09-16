package com.rageh.profy.domain.profile

import androidx.lifecycle.liveData
import com.rageh.profy.data.entity.FullUserProfile
import com.rageh.profy.data.repository.UserProfilesRepo
import kotlinx.coroutines.Dispatchers
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

    fun activateProfile(profileUrl: String) = liveData<Boolean>(Dispatchers.IO) {
        try {
            val profileId =
                profileUrl.substring(profileUrl.lastIndexOf('/') + 1, profileUrl.length).toLong()
            val profile = userProfilesRepo.getFullUserProfile(profileId)
            profile?.let {
                activateProfile(it)
                emit(true)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(false)
        }
        emit(false)
    }
}