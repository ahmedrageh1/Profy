package com.rageh.profy.presentation.ui.trigger

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rageh.profy.R
import com.rageh.profy.databinding.FragmentTimeTriggerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TimeTriggerFragment : Fragment() {

    private var binding: FragmentTimeTriggerBinding? = null

    private val viewModel: TimeTriggerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentTimeTriggerBinding.inflate(
            inflater,
            container, false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            binding = this
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_save -> {

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}