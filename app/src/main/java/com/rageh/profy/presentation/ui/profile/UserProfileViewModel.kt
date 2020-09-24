package com.rageh.profy.presentation.ui.profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.rageh.profy.data.repository.AudioProfilesRepo
import com.rageh.profy.data.repository.DisplayProfilesRepo
import com.rageh.profy.data.repository.UserProfilesRepo
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class UserProfileViewModel @ViewModelInject constructor(
    private val audioProfilesRepo: AudioProfilesRepo,
    private val displayProfilesRepo: DisplayProfilesRepo,
    private val repo: UserProfilesRepo
) :
    ViewModel() {
    var includeAudioProfile = MutableLiveData(false)
    var includeDisplayProfile = MutableLiveData(false)

    val availableAudioProfiles by lazy {
        audioProfilesRepo.getAllAudioProfiles()
    }

    val availableDisplayProfiles by lazy {
        displayProfilesRepo.getAllDisplayProfiles()
    }

    val defaultProfile by lazy {
        repo.getDefaultUserProfile().map {
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
        return repo.insertLive(requireNotNull(defaultProfile.value))
    }


}

