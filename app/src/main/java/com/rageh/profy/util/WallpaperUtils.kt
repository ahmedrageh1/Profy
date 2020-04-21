package com.rageh.profy.util

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
import android.os.Build
import com.rageh.profy.dagger.ScopeApplication
import java.io.InputStream
import javax.inject.Inject

@ScopeApplication
public class WallpaperUtils() {
    @Inject
    lateinit var context: Context

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