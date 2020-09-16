package com.rageh.profy.data.entity

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profiles")
data class UserProfile(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String = "",
    var audioProfileId: Long = 0
) : BaseObservable()