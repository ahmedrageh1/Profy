package com.rageh.profy.util

import android.content.ContentResolver
import android.content.Context
import android.provider.Settings
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ahmed on 2/25/2019.
 */
@Singleton
class DisplayUtils @Inject constructor(@ApplicationContext private val context: Context) {

    private val contentResolver: ContentResolver by lazy {
        context.contentResolver
    }

    @Throws(Settings.SettingNotFoundException::class)
    fun isDisplayAutoBrightness() =
        Settings.System.getInt(
            contentResolver,
            Settings.System.SCREEN_BRIGHTNESS_MODE
        ) == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC

    @Throws(Settings.SettingNotFoundException::class)
    fun getDisplayBrightness() =
        Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS)

    @Throws(Settings.SettingNotFoundException::class)
    fun getScreenOffTimeout() =
        Settings.System.getInt(contentResolver, Settings.System.SCREEN_OFF_TIMEOUT)

    @Throws(Settings.SettingNotFoundException::class)
    fun isAutoRotationEnabled() =
        Settings.System.getInt(contentResolver, Settings.System.ACCELEROMETER_ROTATION) == 1

    @Throws(Settings.SettingNotFoundException::class)
    fun setDisplayAutoBrightnessEnabled(enabled: Boolean) =
        Settings.System.putInt(
            contentResolver,
            Settings.System.SCREEN_BRIGHTNESS_MODE,
            if (enabled) Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC else Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL
        )

    @Throws(Settings.SettingNotFoundException::class)
    fun setDisplayBrightness(brightness: Int) =
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness)

    @Throws(Settings.SettingNotFoundException::class)
    fun setScreenOffTimeout(timeout: Int) =
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_OFF_TIMEOUT, timeout)

    @Throws(Settings.SettingNotFoundException::class)
    fun setAutoRotationEnabled(enabled: Boolean) =
        Settings.System.putInt(
            contentResolver, Settings.System.ACCELEROMETER_ROTATION, if (enabled) 1 else 0
        )

}