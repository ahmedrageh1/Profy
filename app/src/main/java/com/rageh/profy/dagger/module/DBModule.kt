package com.rageh.profy.dagger.module

import android.content.Context
import androidx.room.Room
import com.rageh.profy.model.databse.SettingsProfilesDatabase
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
}