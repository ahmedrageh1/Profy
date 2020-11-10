package com.rageh.profy.data.databse

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rageh.profy.data.databse.converter.DateTime
import com.rageh.profy.data.databse.dao.*
import com.rageh.profy.data.entity.*

@Database(
    entities = arrayOf(
        UserProfile::class,
        AudioProfile::class,
        DisplayProfile::class,
        WallpaperProfile::class,
        ProfileTrigger::class
    ), version = 1
)
@TypeConverters(DateTime::class)
abstract class SettingsProfilesDatabase : RoomDatabase() {

    abstract fun userProfiles(): UserProfileDao
    abstract fun audioProfiles(): AudioProfileDao
    abstract fun displayProfiles(): DisplayProfileDao
    abstract fun wallPaperProfiles(): WallpaperProfileDao
    abstract fun profileTriggers(): ProfileTriggerDao
}