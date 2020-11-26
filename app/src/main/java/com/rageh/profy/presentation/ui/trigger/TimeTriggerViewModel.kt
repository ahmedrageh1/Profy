package com.rageh.profy.presentation.ui.trigger

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rageh.profy.domain.trigger.TimeTriggerHandler
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class TimeTriggerViewModel @ViewModelInject constructor(handler: TimeTriggerHandler) : ViewModel() {
    val trigger = MutableLiveData(handler.createTimeTrigger())


}