package com.rageh.profy.model.databse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rageh.profy.model.databse.dao.*
import com.rageh.profy.model.entity.*

@Database(
    entities = arrayOf(
        UserProfile::class,
        AudioProfile::class,
        DisplayProfile::class,
        WallpaperProfile::class,
        ProfileTrigger::class
    ), version = 1
)
abstract class SettingsProfilesDatabase : RoomDatabase() {

    abstract fun userProfiles(): UserProfileDao
    abstract fun audioProfiles(): AudioProfileDao
    abstract fun displayProfiles(): DisplayProfileDao
    abstract fun wallPaperProfiles(): WallpaperProfileDao
    abstract fun profileTriggers(): ProfileTriggerDao
}