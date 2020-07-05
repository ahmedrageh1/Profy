package com.rageh.profy.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.rageh.profy.model.repository.UserProfilesRepo

class UserProfileViewModel
@ViewModelInject constructor(private val userProfilesRepo: UserProfilesRepo) : ViewModel() {

    val userProfiles by lazy {
        loadUserProfiles()
    }


    private fun loadUserProfiles() = userProfilesRepo.getAllUserProfiles()

}