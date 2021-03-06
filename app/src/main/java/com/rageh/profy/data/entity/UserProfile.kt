package com.rageh.profy.data.entity

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rageh.profy.data.entity.skeleton.IdentifiedItem

@Entity(tableName = "user_profiles")
data class UserProfile(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String = "",
    var audioProfileId: Long = 0,
    var displayProfileId: Long = 0,
    var wallpaperProfileId: Long = 0,
    var triggerId: Long = 0
) : BaseObservable(), IdentifiedItem {
    override fun getIdentifier() = id
}