package com.rageh.profy.presentation.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.rageh.profy.R
import com.rageh.profy.databinding.FragmentHomeBinding
import com.rageh.profy.presentation.adapter.UserProfilesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {


    private val viewModel: HomeViewModel by viewModels()
    private val adapter: UserProfilesAdapter by lazy {
        UserProfilesAdapter(viewModel)
    }

    private lateinit var binding: FragmentHomeBinding

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      return  FragmentHomeBinding.inflate(inflater,container,false).apply { binding=this }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
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