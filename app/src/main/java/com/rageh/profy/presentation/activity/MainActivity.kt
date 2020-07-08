package com.rageh.profy.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.rageh.profy.R
import com.rageh.profy.data.databse.SettingsProfilesDatabase
import com.rageh.profy.data.entity.UserProfile
import com.rageh.profy.presentation.adapter.UserProfilesAdapter
import com.rageh.profy.presentation.viewmodel.UserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var settingsProfilesDatabase: SettingsProfilesDatabase

    private val userProfileViewModel: UserProfileViewModel by viewModels()
    private val adapter: UserProfilesAdapter by lazy {
        UserProfilesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter
        userProfileViewModel.userProfiles.observe(this, Observer<List<UserProfile>> {
            adapter.submitList(it)
        })
        addBt.setOnClickListener {
            userProfileViewModel.insertUserProfile(
                UserProfile(
                    0,
                    "test ${System.currentTimeMillis()}"
                )
            )
        }
    }
}