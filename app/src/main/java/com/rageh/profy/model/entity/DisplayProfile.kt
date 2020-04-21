package com.rageh.profy.model.entity

import android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
import android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL
import androidx.annotation.IntDef
import androidx.room.*

/**
 * Created by Ahmed on 2/27/2019.
 */
@Entity(
    tableName = "display_profiles",
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
data class DisplayProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "user_profile_id")
    var userProfileId: Int,
    @ColumnInfo(name = "screen_brightness_mode")
    @ScreenBrightnessMode
    var screenBrightnessMode: Int,
    @ColumnInfo(name = "screen_brightness")
    var screenBrightness: Int,
    @ColumnInfo(name = "screen_off_timeout")
    var screenOffTimeout: Int
) {
    @IntDef(
        SCREEN_BRIGHTNESS_MODE_MANUAL,
        SCREEN_BRIGHTNESS_MODE_AUTOMATIC
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class ScreenBrightnessMode
}