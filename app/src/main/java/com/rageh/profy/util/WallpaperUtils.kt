package com.rageh.profy.util

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
public class WallpaperUtils(@Inject var context: Context) {

    fun setWallpaper(someBitmap: Bitmap) {
        val wallpaperManager = WallpaperManager.getInstance(context)
        wallpaperManager.setBitmap(someBitmap)
    }

}