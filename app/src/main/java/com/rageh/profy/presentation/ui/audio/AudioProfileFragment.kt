package com.rageh.profy.presentation.ui.audio

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rageh.profy.R
import com.rageh.profy.databinding.FragmentAudioProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AudioProfileFragment : Fragment() {

    private val viewModel: AudioProfileViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentAudioProfileBinding>(
            inflater,
            R.layout.fragment_audio_profile,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_save -> {
                viewModel.saveAudioProfile().observe(viewLifecycleOwner, {
                    Log.d("success", it.toString())
                })
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}