package com.rageh.profy.util

import android.content.ContentResolver
import android.provider.Settings
import com.rageh.profy.dagger.ScopeApplication

/**
 * Created by Ahmed on 2/25/2019.
 */
@ScopeApplication
class DisplayUtils {

    @Throws(Settings.SettingNotFoundException::class)
    fun getDisplayBrightnessMode(contentResolver: ContentResolver) =
            Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE)

    @Throws(Settings.SettingNotFoundException::class)
    fun getDisplayBrightness(contentResolver: ContentResolver) =
            Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS)

    @Throws(Settings.SettingNotFoundException::class)
    fun getScreenOffTimeout(contentResolver: ContentResolver) =
        Settings.System.getInt(contentResolver, Settings.System.SCREEN_OFF_TIMEOUT)

    @Throws(Settings.SettingNotFoundException::class)
    fun setDisplayBrightnessMode(contentResolver: ContentResolver, mode: Int) =
            Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, mode)

    @Throws(Settings.SettingNotFoundException::class)
    fun setDisplayBrightness(contentResolver: ContentResolver, brightness: Int) =
            Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness)

    @Throws(Settings.SettingNotFoundException::class)
    fun setScreenOffTimeout(contentResolver: ContentResolver, timeout: Int) =
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_OFF_TIMEOUT, timeout)
}