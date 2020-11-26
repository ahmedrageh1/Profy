package com.rageh.profy.presentation.ui.trigger

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.rageh.profy.R

class TriggerTypeDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle(R.string.select_trigger_type)
            .setSingleChoiceItems(R.array.trigger_types, -1) { _, which ->
                when (which) {
                    0 -> findNavController().navigate(R.id.timeTriggerFragment)
                    else -> Toast.makeText(
                        requireContext(),
                        R.string.msg_unavailable_in_this_version,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            .create()

    }
}