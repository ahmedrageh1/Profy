package com.rageh.profy.domain.profile

import com.rageh.profy.data.entity.AudioProfile
import com.rageh.profy.util.AudioUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioHandler @Inject constructor(private val audioUtils: AudioUtils) {

    fun getCurrentProfile() = audioUtils.run {
        AudioProfile(
            ringerMode = getRingerMode(),
            ringLevel = getRingLevel(),
            callLevel = getCallLevel(),
            musicLevel = getMusicLevel(),
            systemLevel = getSystemLevel(),
            notificationLevel = getNotificationLevel()
        )
    }

    fun setCurrentProfile(audioProfile: AudioProfile) = audioUtils.run {
        setRingerMode(audioProfile.ringerMode)
        setCallLevel(audioProfile.callLevel)
        setCallLevel(audioProfile.callLevel)
        setMusicLevel(audioProfile.musicLevel)
        setSystemLevel(audioProfile.systemLevel)
        setNotificationLevel(audioProfile.notificationLevel)
    }
}