package com.rageh.profy.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rageh.profy.R
import com.rageh.profy.viewmodel.UserProfileViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userProfileViewModel: UserProfileViewModel by viewModels()
//        userProfileViewModel.userProfiles
    }
}