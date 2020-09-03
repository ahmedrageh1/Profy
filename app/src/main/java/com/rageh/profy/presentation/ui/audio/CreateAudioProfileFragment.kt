package com.rageh.profy.presentation.ui.audio

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rageh.profy.R

class CreateAudioProfileFragment : Fragment(R.layout.fragment_create_audio_profile) {

    private val viewModel: CreateAudioProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}