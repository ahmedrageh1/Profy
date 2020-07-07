package com.rageh.profy.model.repository

import com.rageh.profy.model.databse.dao.AudioProfileDao
import com.rageh.profy.model.entity.AudioProfile
import com.rageh.profy.model.repository.base.BaseRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioProfilesRepo @Inject constructor(private val audioProfileDao: AudioProfileDao) :
    BaseRepo<AudioProfile>(audioProfileDao) {

    fun getAudioProfile(profileId: Long) = audioProfileDao.getAudioProfile(profileId)

    fun getAllAudioProfiles() =
        audioProfileDao.getAllAudioProfiles()
}