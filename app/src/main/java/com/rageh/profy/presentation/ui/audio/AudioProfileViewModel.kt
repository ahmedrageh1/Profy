package com.rageh.profy.presentation.ui.audio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rageh.profy.domain.profile.AudioProfileHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class AudioProfileViewModel @Inject constructor(
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
    }).asLiveData(Dispatchers.IO)

}