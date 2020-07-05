package com.rageh.profy.util

import android.content.Context
import android.media.AudioManager
import com.rageh.profy.model.entity.AudioProfile
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

    fun setRingerMode(@AudioProfile.RingMode ringerMode: Int) {
        am.ringerMode = ringerMode
    }

    fun setRingLevel(level: Int) = am.setStreamVolume(AudioManager.STREAM_RING, level, 0)
    fun setCallLevel(level: Int) = am.setStreamVolume(AudioManager.STREAM_VOICE_CALL, level, 0)
    fun setMusicLevel(level: Int) = am.setStreamVolume(AudioManager.STREAM_MUSIC, level, 0)

    fun getRingerMode(): Int = am.ringerMode
    fun getMaxRingLevel(): Int = am.getStreamMaxVolume(AudioManager.STREAM_RING)
    fun getMaxMusicLevel(): Int = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
    fun getMaxCallLevel(): Int = am.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL)


}