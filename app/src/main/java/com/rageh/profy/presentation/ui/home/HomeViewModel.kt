package com.rageh.profy.presentation.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.rageh.profy.data.entity.UserProfile
import com.rageh.profy.data.repository.UserProfilesRepo
import dagger.hilt.android.scopes.ActivityRetainedScoped

@ActivityRetainedScoped
class HomeViewModel
@ViewModelInject constructor(private val userProfilesRepo: UserProfilesRepo) : ViewModel() {

    val userProfiles by lazy {
        loadUserProfiles()
    }

    private fun loadUserProfiles() = userProfilesRepo.getAllUserProfiles()

    fun insertUserProfile(userProfile: UserProfile) =
        userProfilesRepo.insertIntoDB(userProfile)


}