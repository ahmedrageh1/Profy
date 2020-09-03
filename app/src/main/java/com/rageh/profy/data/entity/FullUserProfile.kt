package com.rageh.profy.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FullUserProfile(
    @Embedded val profile: UserProfile,
    @Relation(
        parentColumn = "audioProfileId",
        entityColumn = "id"
    )
    val audioProfile: AudioProfile? = null
)