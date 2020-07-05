package com.rageh.profy.util

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
import android.os.Build
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WallpaperUtils @Inject constructor(@ApplicationContext private val context: Context) {

    fun setWallpaper(someBitmap: Bitmap) {
        val wallpaperManager = WallpaperManager.getInstance(context)
        wallpaperManager.setBitmap(someBitmap)
    }

    fun setWallpaper(someBitmapInputStream: InputStream, visibleCropHint: Rect, which: Int) {
        val wallpaperManager = WallpaperManager.getInstance(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            wallpaperManager.setStream(someBitmapInputStream, visibleCropHint, false, which)
        } else {
            wallpaperManager.setStream(someBitmapInputStream)
        }
    }

}