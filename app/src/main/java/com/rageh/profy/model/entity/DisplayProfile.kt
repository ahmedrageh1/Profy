package com.rageh.profy.model.entity

import android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
import android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL
import androidx.annotation.IntDef
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Ahmed on 2/27/2019.
 */
@Entity(
    tableName = "display_profiles"
)
data class DisplayProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "screen_brightness_mode")
    @ScreenBrightnessMode
    val screenBrightnessMode: Int,
    @ColumnInfo(name = "screen_brightness")
    val screenBrightness: Int,
    @ColumnInfo(name = "screen_off_timeout")
    val screenOffTimeout: Int
) {
    @IntDef(
        SCREEN_BRIGHTNESS_MODE_MANUAL,
        SCREEN_BRIGHTNESS_MODE_AUTOMATIC
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class ScreenBrightnessMode
}