package com.rageh.profy.domain.trigger

import com.rageh.profy.data.repository.ProfileTriggerRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimeTriggerHandler @Inject constructor(val repo: ProfileTriggerRepo) {

    fun createTimeTrigger() = repo.createTimeTrigger()

}