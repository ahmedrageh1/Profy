package com.rageh.profy.presentation.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.rageh.profy.R
import com.rageh.profy.databinding.FragmentUserProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_user_profile.*

@AndroidEntryPoint
class UserProfileFragment : Fragment() {

    private val viewModel: UserProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return DataBindingUtil.inflate<FragmentUserProfileBinding>(
            inflater,
            R.layout.fragment_user_profile,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addAudioProfileBt.setOnClickListener {
            view.findNavController().navigate(R.id.audioProfileFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_save -> {
                viewModel.saveUserProfile().observe(viewLifecycleOwner, {
                    Log.d("success", it.toString())
                })
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}