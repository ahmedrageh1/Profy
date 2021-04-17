package com.rageh.profy.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rageh.profy.data.entity.FullUserProfile
import com.rageh.profy.data.entity.UserProfile
import com.rageh.profy.domain.profile.UserProfileHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val handler: UserProfileHandler) : ViewModel() {

    val userProfiles by lazy {
        loadUserProfiles().asLiveData(Dispatchers.IO)
    }

    private fun loadUserProfiles() = handler.loadUserProfiles()

    fun applyProfile(userProfile: FullUserProfile) = handler.applyProfile(userProfile)

    fun insertUserProfile(userProfile: UserProfile) =
        handler.insertUserProfile(userProfile).asLiveData(Dispatchers.IO)


}