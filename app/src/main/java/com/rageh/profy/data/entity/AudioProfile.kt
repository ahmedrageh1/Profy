package com.rageh.profy.data.entity

import android.media.AudioManager
import androidx.annotation.IntDef
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Ahmed on 2/27/2019.
 */
@Entity(tableName = "audio_profiles")
data class AudioProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "ringer_mode")
    @RingMode
    val ringerMode: Int,
    @ColumnInfo(name = "ring_level")
    val ringLevel: Int,
    @ColumnInfo(name = "call_level")
    val callLevel: Int,
    @ColumnInfo(name = "music_level")
    val musicLevel: Int,
    @ColumnInfo(name = "system_level")
    val systemLevel: Int,
    @ColumnInfo(name = "alarm_level")
    val alarmLevel: Int,
    @ColumnInfo(name = "notification_level")
    val notificationLevel: Int
//TODO add delay seconds option 
) {
    @IntDef(
        AudioManager.RINGER_MODE_SILENT,
        AudioManager.RINGER_MODE_VIBRATE,
        AudioManager.RINGER_MODE_NORMAL
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class RingMode
}