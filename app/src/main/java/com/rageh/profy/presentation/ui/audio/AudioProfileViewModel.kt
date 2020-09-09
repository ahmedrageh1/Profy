package com.rageh.profy.presentation.ui.audio

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.rageh.profy.data.entity.AudioProfile
import com.rageh.profy.data.repository.AudioProfilesRepo
import com.rageh.profy.domain.profile.AudioHandler
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class AudioProfileViewModel @ViewModelInject constructor(
    private val handler: AudioHandler,
    private val repo: AudioProfilesRepo
) :
    ViewModel() {

    val currentAudioProfile by lazy {
        handler.getCurrentProfile()
    }

    val maxLevelProfile by lazy {
        handler.getMaxLevelsProfile()
    }

    fun saveAudioProfile(
        name: String, ringerMode: Int, ringLevel: Int,
        callLevel: Int, musicLevel: Int, systemLevel: Int,
        alarmLevel: Int, notificationLevel: Int
    ) =
        repo.insertIntoDB(
            AudioProfile(
                name = name,
                ringerMode = ringerMode,
                ringLevel = ringLevel,
                callLevel = callLevel,
                musicLevel = musicLevel,
                systemLevel = systemLevel,
                alarmLevel = alarmLevel,
                notificationLevel = notificationLevel
            )
        )


}