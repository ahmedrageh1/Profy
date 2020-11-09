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

    private val wpm: WallpaperManager by lazy {
        WallpaperManager.getInstance(context)
    }

    fun setWallpaper(someBitmap: Bitmap) =
        wpm.setBitmap(someBitmap)

    fun setWallpaper(someBitmapInputStream: InputStream, visibleCropHint: Rect, which: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            wpm.setStream(someBitmapInputStream, visibleCropHint, false, which)
        } else {
            wpm.setStream(someBitmapInputStream)
        }
    }

}