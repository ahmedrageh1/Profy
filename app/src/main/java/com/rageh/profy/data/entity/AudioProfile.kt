package com.rageh.profy.data.entity

import android.media.AudioManager
import androidx.annotation.IntDef
import androidx.databinding.BaseObservable
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
    var ringerMode: Int,
    @ColumnInfo(name = "ring_level")
    var ringLevel: Int,
    @ColumnInfo(name = "call_level")
    var callLevel: Int,
    @ColumnInfo(name = "music_level")
    var musicLevel: Int,
    @ColumnInfo(name = "system_level")
    var systemLevel: Int,
    @ColumnInfo(name = "alarm_level")
    var alarmLevel: Int,
    @ColumnInfo(name = "notification_level")
    var notificationLevel: Int
//TODO add delay seconds option 
) : BaseObservable() {
    @IntDef(
        AudioManager.RINGER_MODE_SILENT,
        AudioManager.RINGER_MODE_VIBRATE,
        AudioManager.RINGER_MODE_NORMAL
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class RingMode

    override fun toString(): String {
        return name
    }
}