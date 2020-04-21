package com.rageh.profy.model.entity

import android.graphics.Rect
import androidx.room.*

/**
 * Created by Ahmed on 4/19/2020.
 */
@Entity(
    tableName = "wallpaper_profiles",
    foreignKeys = [
        ForeignKey(
            entity = UserProfile::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("user_profile_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
    , indices = [Index("user_profile_id", unique = true)]
)
data class WallpaperProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "user_profile_id")
    var userProfileId: Int,
    @ColumnInfo(name = "system_file_uri")
    var systemFileUri: String,
    @Embedded(prefix = "system_rect")
    var systemRect: Rect,
    @ColumnInfo(name = "lock_file_uri")
    var lockFileUri: String,
    @Embedded(prefix = "lock_rect")
    var lockRect: Rect
)