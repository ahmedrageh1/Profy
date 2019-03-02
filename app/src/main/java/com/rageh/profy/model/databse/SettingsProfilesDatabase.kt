package com.rageh.profy.model.databse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rageh.profy.model.databse.dao.AudioProfileDao
import com.rageh.profy.model.databse.dao.DisplayProfileDao
import com.rageh.profy.model.databse.dao.UserProfileDao
import com.rageh.profy.model.entity.AudioProfile
import com.rageh.profy.model.entity.DisplayProfile
import com.rageh.profy.model.entity.UserProfile

@Database(
    entities = arrayOf(
        UserProfile::class,
        AudioProfile::class,
        DisplayProfile::class
    ), version = 1
)
abstract class SettingsProfilesDatabase : RoomDatabase() {

    abstract fun userProfiles(): UserProfileDao
    abstract fun audioProfiles(): AudioProfileDao
    abstract fun displayProfiles(): DisplayProfileDao
}