package com.rageh.profy.presentation.ui.profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.rageh.profy.data.repository.AudioProfilesRepo
import com.rageh.profy.data.repository.UserProfilesRepo
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class UserProfileViewModel @ViewModelInject constructor(
    private val audioProfilesRepo: AudioProfilesRepo,
    private val repo: UserProfilesRepo
) :
    ViewModel() {

    val availableAudioProfiles by lazy {
        audioProfilesRepo.getAllAudioProfiles()
    }

    val defaultProfile by lazy {
        repo.getDefaultUserProfile().map {
            it.apply {
                id = 0
                name = ""
            }
        }
    }

    fun saveUserProfile() = repo.insertLive(requireNotNull(defaultProfile.value))

}