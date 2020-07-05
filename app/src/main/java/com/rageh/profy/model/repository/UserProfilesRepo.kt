package com.rageh.profy.model.repository

import androidx.lifecycle.LiveData
import com.rageh.profy.model.databse.SettingsProfilesDatabase
import com.rageh.profy.model.entity.UserProfile
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProfilesRepo @Inject constructor(private val settingsProfilesDatabase: SettingsProfilesDatabase) {
    fun getAllUserProfiles(): LiveData<List<UserProfile>> =
        settingsProfilesDatabase.userProfiles().getAllProfiles()
}