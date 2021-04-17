package com.rageh.profy.presentation.ui.display

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rageh.profy.domain.profile.DisplayProfileHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DisplayProfileViewModel @Inject constructor(
    private val handler: DisplayProfileHandler
) :
    ViewModel() {


    val screenTimeoutValues = arrayListOf(
        10000,  //10 sec
        30000,  //30 sec
        60000,  //1 min
        120000, //2 min
        300000, //5min
        600000, //10 min
        Integer.MAX_VALUE //Never
    )

    val currentDisplayProfile by lazy {
        handler.getCurrentProfile()
    }

    val screenTimeoutIndex = MutableLiveData(initScreenTimeoutIndex())

    var autoBrightness = MutableLiveData(currentDisplayProfile.screenAutoBrightness)

    private fun initScreenTimeoutIndex(): Int {
        val index = screenTimeoutValues.indexOf(currentDisplayProfile.screenOffTimeout)
        return if (index == -1) {
            screenTimeoutValues.indexOf(requireNotNull(screenTimeoutValues.minByOrNull {
                kotlin.math.abs(
                    currentDisplayProfile.screenOffTimeout - it
                )
            }))
        } else {
            index
        }
    }

    fun saveDisplayProfile() = handler.insert(currentDisplayProfile.apply {
        screenAutoBrightness = requireNotNull(autoBrightness.value)
        screenOffTimeout = screenTimeoutValues[requireNotNull(screenTimeoutIndex.value)]
    }).asLiveData(Dispatchers.IO)

}