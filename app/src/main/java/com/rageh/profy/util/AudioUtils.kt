package com.rageh.profy.util

import android.content.Context
import android.media.AudioManager
import com.rageh.profy.data.entity.AudioProfile
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Ahmed on 2/10/2019.
 */
@Singleton
class AudioUtils @Inject constructor(@ApplicationContext private val context: Context) {

    private val am: AudioManager by lazy {
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    }

    fun getRingerMode(): Int = am.ringerMode

    fun setRingerMode(@AudioProfile.RingMode ringerMode: Int) {
        am.ringerMode = ringerMode
    }

    fun setRingLevel(level: Int) = am.setStreamVolume(AudioManager.STREAM_RING, level, 0)
    fun setCallLevel(level: Int) = am.setStreamVolume(AudioManager.STREAM_VOICE_CALL, level, 0)
    fun setMusicLevel(level: Int) = am.setStreamVolume(AudioManager.STREAM_MUSIC, level, 0)
    fun setSystemLevel(level: Int) = am.setStreamVolume(AudioManager.STREAM_SYSTEM, level, 0)
    fun setAlarmLevel(level: Int) = am.setStreamVolume(AudioManager.STREAM_ALARM, level, 0)
    fun setNotificationLevel(level: Int) =
        am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, level, 0)

    fun getRingLevel(): Int = am.getStreamVolume(AudioManager.STREAM_RING)
    fun getMusicLevel(): Int = am.getStreamVolume(AudioManager.STREAM_MUSIC)
    fun getCallLevel(): Int = am.getStreamVolume(AudioManager.STREAM_VOICE_CALL)
    fun getSystemLevel(): Int = am.getStreamVolume(AudioManager.STREAM_SYSTEM)
    fun getAlarmLevel(): Int = am.getStreamVolume(AudioManager.STREAM_ALARM)
    fun getNotificationLevel(): Int = am.getStreamVolume(AudioManager.STREAM_NOTIFICATION)

    fun getMaxRingLevel(): Int = am.getStreamMaxVolume(AudioManager.STREAM_RING)
    fun getMaxMusicLevel(): Int = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
    fun getMaxCallLevel(): Int = am.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL)
    fun getMaxSystemLevel(): Int = am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM)
    fun getMaxAlarmLevel(): Int = am.getStreamMaxVolume(AudioManager.STREAM_ALARM)
    fun getMaxNotificationLevel(): Int = am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION)


}