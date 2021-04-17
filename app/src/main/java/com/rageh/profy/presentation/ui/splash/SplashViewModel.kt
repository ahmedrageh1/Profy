package com.rageh.profy.presentation.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.rageh.profy.domain.profile.UserProfileHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val handler: UserProfileHandler
) :
    ViewModel() {
    val defaultProfile by lazy {
        handler.getDefaultUserProfile().asLiveData(Dispatchers.IO)
    }

    fun initDefaultProfile() = viewModelScope.launch { handler.createAndInsertDefaultProfile() }

}