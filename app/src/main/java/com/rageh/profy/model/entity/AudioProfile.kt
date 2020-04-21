package com.rageh.profy.model.entity

import android.media.AudioManager
import androidx.annotation.IntDef
import androidx.room.*

/**
 * Created by Ahmed on 2/27/2019.
 */
@Entity(
    tableName = "audio_profiles",
    foreignKeys = [
        ForeignKey(
            entity = UserProfile::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("user_profile_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
    , indices = [Index("user_profile_id", unique = true)]
)
data class AudioProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "user_profile_id")
    var userProfileId: Long,
    @ColumnInfo(name = "ringer_mode")
    @RingMode
    var ringerMode: Int,
    @ColumnInfo(name = "ring_level")
    var ringLevel: Int,
    @ColumnInfo(name = "call_level")
    var callLevel: Int,
    @ColumnInfo(name = "music_level")
    var musicLevel: Int

) {
    @IntDef(
        AudioManager.RINGER_MODE_NORMAL,
        AudioManager.RINGER_MODE_SILENT,
        AudioManager.RINGER_MODE_VIBRATE
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class RingMode
}