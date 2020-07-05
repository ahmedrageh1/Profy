package com.rageh.profy.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.rageh.profy.R
import com.rageh.profy.model.databse.SettingsProfilesDatabase
import com.rageh.profy.model.entity.UserProfile
import com.rageh.profy.ui.adapter.UserProfilesAdapter
import com.rageh.profy.viewmodel.UserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var settingsProfilesDatabase: SettingsProfilesDatabase

    private val adapter: UserProfilesAdapter by lazy {
        UserProfilesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userProfileViewModel: UserProfileViewModel by viewModels()
        recyclerView.adapter = adapter
        userProfileViewModel.userProfiles.observe(this, Observer<List<UserProfile>> {
            adapter.submitList(it)
        })
        addBt.setOnClickListener {
            settingsProfilesDatabase.userProfiles()
                .insert(UserProfile(0, "test ${System.currentTimeMillis()}"))
        }
    }
}