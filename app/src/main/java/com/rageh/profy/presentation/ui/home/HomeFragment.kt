package com.rageh.profy.presentation.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.rageh.profy.R
import com.rageh.profy.domain.profile.UserProfileHandler
import com.rageh.profy.presentation.adapter.UserProfilesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    @Inject
    lateinit var profileHandler: UserProfileHandler

    private val viewModel: HomeViewModel by viewModels()
    private val adapter: UserProfilesAdapter by lazy {
        UserProfilesAdapter(profileHandler)
    }

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.apply {
            adapter = this@HomeFragment.adapter
            setHasFixedSize(true)
        }
        viewModel.userProfiles.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_add -> {
                view?.findNavController()?.navigate(R.id.userProfileFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}