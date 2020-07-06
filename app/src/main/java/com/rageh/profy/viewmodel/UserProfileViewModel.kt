package com.rageh.profy.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rageh.profy.model.entity.UserProfile
import com.rageh.profy.model.repository.UserProfilesRepo
import kotlinx.coroutines.launch

class UserProfileViewModel
@ViewModelInject constructor(private val userProfilesRepo: UserProfilesRepo) : ViewModel() {

    val userProfiles by lazy {
        loadUserProfiles()
    }


    private fun loadUserProfiles() = userProfilesRepo.getAllUserProfiles()

    fun insertUserProfile(userProfile: UserProfile) {
        viewModelScope.launch {
            userProfilesRepo.insertIntoDB(userProfile)
        }
    }

}