package com.rageh.profy.presentation.ui.profile

import androidx.lifecycle.*
import com.rageh.profy.domain.profile.AudioProfileHandler
import com.rageh.profy.domain.profile.DisplayProfileHandler
import com.rageh.profy.domain.profile.UserProfileHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val audioProfilesHandler: AudioProfileHandler,
    private val displayProfilesHandler: DisplayProfileHandler,
    private val userProfileHandler: UserProfileHandler
) :
    ViewModel() {
    var includeAudioProfile = MutableLiveData(false)
    var includeDisplayProfile = MutableLiveData(false)

    val availableAudioProfiles by lazy {
        audioProfilesHandler.getAllAudioProfiles().asLiveData(Dispatchers.IO)
    }

    val availableDisplayProfiles by lazy {
        displayProfilesHandler.getAllDisplayProfiles().asLiveData(Dispatchers.IO)
    }

    val defaultProfile by lazy {
        userProfileHandler.getDefaultUserProfile().asLiveData(Dispatchers.IO).map {
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
            .asLiveData(Dispatchers.IO)
    }


}

