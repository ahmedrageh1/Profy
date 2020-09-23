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
    fun getDisplayBrightnessMode() =
        Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE)

    @Throws(Settings.SettingNotFoundException::class)
    fun getDisplayBrightness() =
        Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS)

    @Throws(Settings.SettingNotFoundException::class)
    fun getScreenOffTimeout() =
        Settings.System.getInt(contentResolver, Settings.System.SCREEN_OFF_TIMEOUT)

    @Throws(Settings.SettingNotFoundException::class)
    fun setDisplayBrightnessMode(mode: Int) =
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, mode)

    @Throws(Settings.SettingNotFoundException::class)
    fun setDisplayBrightness(brightness: Int) =
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness)

    @Throws(Settings.SettingNotFoundException::class)
    fun setScreenOffTimeout(timeout: Int) =
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_OFF_TIMEOUT, timeout)

    fun getMaxDisplayBrightness() = 255


}