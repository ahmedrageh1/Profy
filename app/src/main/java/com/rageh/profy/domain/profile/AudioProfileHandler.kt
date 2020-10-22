package com.rageh.profy.domain.profile

import android.media.AudioManager
import com.rageh.profy.data.entity.AudioProfile
import com.rageh.profy.data.repository.AudioProfilesRepo
import com.rageh.profy.util.AudioUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioProfileHandler @Inject constructor(
    private val repo: AudioProfilesRepo,
    private val audioUtils: AudioUtils
) {

    fun getCurrentProfile() = audioUtils.run {
        AudioProfile(
            ringerMode = getRingerMode(),
            ringLevel = getRingLevel(),
            callLevel = getCallLevel(),
            musicLevel = getMusicLevel(),
            systemLevel = getSystemLevel(),
            alarmLevel = getAlarmLevel(),
            notificationLevel = getNotificationLevel()
        )
    }

    fun applyProfile(audioProfile: AudioProfile) = audioUtils.run {
        setRingerMode(audioProfile.ringerMode)
        setCallLevel(audioProfile.callLevel)
        setAlarmLevel(audioProfile.alarmLevel)
        if (audioProfile.ringerMode == AudioManager.RINGER_MODE_NORMAL) {
            setRingLevel(audioProfile.ringLevel)
            setMusicLevel(audioProfile.musicLevel)
            setSystemLevel(audioProfile.systemLevel)
            setNotificationLevel(audioProfile.notificationLevel)
        }
    }

    fun getMaxLevelsProfile() = audioUtils.run {
        AudioProfile(
            ringerMode = getRingerMode(),
            ringLevel = getMaxRingLevel(),
            callLevel = getMaxCallLevel(),
            musicLevel = getMaxMusicLevel(),
            systemLevel = getMaxSystemLevel(),
            alarmLevel = getMaxAlarmLevel(),
            notificationLevel = getMaxNotificationLevel()
        )
    }

    fun insert(audioProfile: AudioProfile) = repo.insertLive(audioProfile)

    fun getAllAudioProfiles() = repo.getAllAudioProfiles()
}