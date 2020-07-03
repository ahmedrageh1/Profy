package com.rageh.profy.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rageh.profy.model.entity.UserProfile

class UserProfileViewModel : ViewModel() {
    val userProfiles by lazy {
        MutableLiveData<List<UserProfile>>()
            .also {
                println("initialized")
//            loadUserProfiles()
            }
    }

    private fun loadUserProfiles() {

    }

}