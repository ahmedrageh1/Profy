package com.rageh.profy.presentation.ui.profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.rageh.profy.domain.profile.AudioProfileHandler
import com.rageh.profy.domain.profile.DisplayProfileHandler
import com.rageh.profy.domain.profile.UserProfileHandler
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class UserProfileViewModel @ViewModelInject constructor(
    private val audioProfilesHandler: AudioProfileHandler,
    private val displayProfilesHandler: DisplayProfileHandler,
    private val userProfileHandler: UserProfileHandler
) :
    ViewModel() {
    var includeAudioProfile = MutableLiveData(false)
    var includeDisplayProfile = MutableLiveData(false)

    val availableAudioProfiles by lazy {
        audioProfilesHandler.getAllAudioProfiles()
    }

    val availableDisplayProfiles by lazy {
        displayProfilesHandler.getAllDisplayProfiles()
    }

    val defaultProfile by lazy {
        userProfileHandler.getDefaultUserProfile().map {
            it.apply {
                id = 0
                name = ""
            }
        }
    }

    fun saveUserProfile(): LiveData<Long> {
        defaultProfile.value?.apply {
            includeAudioProfile.value?.let {
                if (!it) audioProfileId = 0
            }
            includeDisplayProfile.value?.let {
                if (!it) displayProfileId = 0
            }
        }
        return userProfileHandler.insertUserProfile(requireNotNull(defaultProfile.value))
    }


}

