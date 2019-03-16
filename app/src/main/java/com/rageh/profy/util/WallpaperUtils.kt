package com.rageh.profy.util

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import com.rageh.profy.dagger.ScopeApplication
import javax.inject.Inject

@ScopeApplication
public class WallpaperUtils() {
    @Inject
    lateinit var context: Context
    fun setWallpaper(someBitmap: Bitmap) {
        val wallpaperManager = WallpaperManager.getInstance(context)
        wallpaperManager.setBitmap(someBitmap)
    }

}