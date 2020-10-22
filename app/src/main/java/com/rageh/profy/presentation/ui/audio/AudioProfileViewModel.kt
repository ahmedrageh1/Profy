package com.rageh.profy.presentation.ui.audio

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rageh.profy.domain.profile.AudioProfileHandler
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class AudioProfileViewModel @ViewModelInject constructor(
    private val handler: AudioProfileHandler
) :
    ViewModel() {

    val currentAudioProfile by lazy {
        handler.getCurrentProfile()
    }

    val maxLevelProfile by lazy {
        handler.getMaxLevelsProfile()
    }

    val liveRingerMode = MutableLiveData(currentAudioProfile.ringerMode)

    fun saveAudioProfile() = handler.insert(currentAudioProfile.apply {
        ringerMode = requireNotNull(liveRingerMode.value)
    })

}