package com.rageh.profy.di

import android.content.Context
import androidx.room.Room
import com.rageh.profy.data.databse.SettingsProfilesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class DBModule {

    @Inject
    @Provides
    @Singleton
    fun settingsProfilesDatabase(@ApplicationContext context: Context): SettingsProfilesDatabase {
        return Room.databaseBuilder(
            context,
            SettingsProfilesDatabase::class.java, "settings_profiles"
        )
            .build()
    }

    @Inject
    @Provides
    @Singleton
    fun userProfileDao(settingsProfilesDatabase: SettingsProfilesDatabase) =
        settingsProfilesDatabase.userProfiles()

    @Inject
    @Provides
    @Singleton
    fun audioProfileDao(settingsProfilesDatabase: SettingsProfilesDatabase) =
        settingsProfilesDatabase.audioProfiles()

    @Inject
    @Provides
    @Singleton
    fun displayProfileDao(settingsProfilesDatabase: SettingsProfilesDatabase) =
        settingsProfilesDatabase.displayProfiles()

    @Inject
    @Provides
    @Singleton
    fun wallPaperProfileDao(settingsProfilesDatabase: SettingsProfilesDatabase) =
        settingsProfilesDatabase.wallPaperProfiles()

    @Inject
    @Provides
    @Singleton
    fun profileTriggerDao(settingsProfilesDatabase: SettingsProfilesDatabase) =
        settingsProfilesDatabase.profileTriggers()

}