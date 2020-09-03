package com.rageh.profy.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.rageh.profy.R
import com.rageh.profy.data.entity.FullUserProfile
import com.rageh.profy.data.entity.UserProfile
import com.rageh.profy.presentation.adapter.UserProfilesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private val adapter: UserProfilesAdapter by lazy {
        UserProfilesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.apply {
            adapter = this@HomeFragment.adapter
            setHasFixedSize(true)
//            addItemDecoration(
//                DividerItemDecoration(
//                    requireContext(),
//                    LinearLayoutManager.VERTICAL
//                ).also {
//                    ContextCompat.getDrawable(requireContext(), R.drawable.list_divider_4)
//                })
        }
        viewModel.userProfiles.observe(viewLifecycleOwner, Observer<List<FullUserProfile>> {
            adapter.submitList(it)
        })
        addBt.setOnClickListener {
            //TODO to be removed
            viewModel.insertUserProfile(
                UserProfile(
                    0,
                    "test ${System.currentTimeMillis()}", 0
                )
            )
        }
    }


}