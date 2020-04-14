package com.rageh.profy.model.entity

import androidx.room.*

/**
 * Created by Ahmed on 2/27/2019.
 */
@Entity(
    tableName = "audio_profiles",
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
data class AudioProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "user_profile_id")
    var userProfileId: Long
)