package com.rageh.profy.data.entity

import androidx.databinding.BaseObservable
import androidx.room.Embedded
import androidx.room.Relation

data class FullUserProfile(
    @Embedded val profile: UserProfile,
    @Relation(
        parentColumn = "audioProfileId",
        entityColumn = "id"
    )
    val audioProfile: AudioProfile? = null,
    @Relation(
        parentColumn = "displayProfileId",
        entityColumn = "id"
    )
    val displayProfile: DisplayProfile? = null,
    @Relation(
        parentColumn = "wallpaperProfileId",
        entityColumn = "id"
    )
    val wallpaperProfile: WallpaperProfile? = null,
    @Relation(
        parentColumn = "triggerId",
        entityColumn = "id"
    )
    val trigger: ProfileTrigger? = null
) : BaseObservable()