package com.rageh.profy.presentation.ui.audio

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rageh.profy.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_create_audio_profile.*

@AndroidEntryPoint
class CreateAudioProfileFragment : Fragment(R.layout.fragment_create_audio_profile) {

    private val viewModel: CreateAudioProfileViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.maxLevelProfile.apply {
            ringLevelSB.max = ringLevel
            callLevelSB.max = callLevel
            musicLevelSB.max = musicLevel
            systemLevelSB.max = systemLevel
            alarmLevelSB.max = alarmLevel
            notificationLevelSB.max = notificationLevel
        }
        viewModel.currentAudioProfile.observe(viewLifecycleOwner, {
            ringLevelSB.progress = it.ringLevel
            callLevelSB.progress = it.callLevel
            musicLevelSB.progress = it.musicLevel
            systemLevelSB.progress = it.systemLevel
            alarmLevelSB.progress = it.alarmLevel
            notificationLevelSB.progress = it.notificationLevel
        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_save -> {
                viewModel.saveAudioProfile(
                    nameET.text.toString(),
                    ringModeSp.selectedItemPosition,
                    ringLevelSB.progress,
                    callLevelSB.progress,
                    musicLevelSB.progress,
                    systemLevelSB.progress,
                    alarmLevelSB.progress,
                    notificationLevelSB.progress
                ).observe(viewLifecycleOwner, {
                    Log.e("success", it.toString())
                })
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}