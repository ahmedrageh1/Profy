package com.rageh.profy.domain.profile

import androidx.lifecycle.liveData
import com.rageh.profy.data.entity.FullUserProfile
import com.rageh.profy.data.entity.UserProfile
import com.rageh.profy.data.repository.AudioProfilesRepo
import com.rageh.profy.data.repository.UserProfilesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProfileHandler @Inject constructor(
    private val userProfilesRepo: UserProfilesRepo,
    private val audioProfilesRepo: AudioProfilesRepo,
    private val audioProfileHandler: AudioProfileHandler,
    private val displayProfileHandler: DisplayProfileHandler
) {

    suspend fun createAndInsertDefaultProfile() = withContext(Dispatchers.IO) {
        //TODO titles to be replaces with string provider
        userProfilesRepo.insert(UserProfile().apply {
            name = "Default"
            audioProfileId = audioProfilesRepo.insert(
                audioProfileHandler.getCurrentProfile().apply { name = "Default" })
        })
    }

    fun applyProfile(profile: FullUserProfile) {
        profile.audioProfile?.let {
            audioProfileHandler.applyProfile(it)
        }

        profile.displayProfile?.let {
            displayProfileHandler.applyProfile(it)
        }
    }

    fun applyProfile(profileUrl: String) = liveData(Dispatchers.IO) {
        try {
            val profileId =
                profileUrl.substring(profileUrl.lastIndexOf('/') + 1, profileUrl.length).toLong()
            val profile = userProfilesRepo.getFullUserProfile(profileId)
            profile?.let {
                applyProfile(it)
                emit(true)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(false)
        }
        emit(false)
    }
}