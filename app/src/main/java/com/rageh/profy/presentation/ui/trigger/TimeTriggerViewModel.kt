package com.rageh.profy.presentation.ui.trigger

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rageh.profy.domain.trigger.TimeTriggerHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimeTriggerViewModel @Inject constructor(handler: TimeTriggerHandler) : ViewModel() {
    val trigger = MutableLiveData(handler.createTimeTrigger())


}