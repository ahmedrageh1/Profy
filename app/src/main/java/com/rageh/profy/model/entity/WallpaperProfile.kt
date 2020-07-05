package com.rageh.profy.model.entity

import android.graphics.Rect
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Ahmed on 4/19/2020.
 */
@Entity(tableName = "wallpaper_profiles")
data class WallpaperProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "system_file_uri")
    val systemFileUri: String,
    @Embedded(prefix = "system_rect")
    val systemRect: Rect,
    @ColumnInfo(name = "lock_file_uri")
    val lockFileUri: String,
    @Embedded(prefix = "lock_rect")
    val lockRect: Rect
)