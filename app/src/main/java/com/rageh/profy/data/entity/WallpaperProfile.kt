package com.rageh.profy.data.entity

import android.graphics.Rect
import androidx.databinding.BaseObservable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rageh.profy.data.entity.skeleton.IdentifiedItem

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
) : BaseObservable(), IdentifiedItem {
    override fun getIdentifier() = id
}