package com.rageh.profy.presentation.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.rageh.profy.data.entity.FullUserProfile
import com.rageh.profy.data.entity.UserProfile
import com.rageh.profy.domain.profile.UserProfileHandler
import dagger.hilt.android.scopes.ActivityRetainedScoped

@ActivityRetainedScoped
class HomeViewModel
@ViewModelInject constructor(private val handler: UserProfileHandler) : ViewModel() {

    val userProfiles by lazy {
        loadUserProfiles()
    }

    private fun loadUserProfiles() = handler.loadUserProfiles()

    fun applyProfile(userProfile: FullUserProfile) = handler.applyProfile(userProfile)

    fun insertUserProfile(userProfile: UserProfile) =
        handler.insertUserProfile(userProfile)


}