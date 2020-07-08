package com.rageh.profy.data.repository

import com.rageh.profy.data.databse.dao.AudioProfileDao
import com.rageh.profy.data.entity.AudioProfile
import com.rageh.profy.data.repository.base.BaseRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioProfilesRepo @Inject constructor(private val audioProfileDao: AudioProfileDao) :
    BaseRepo<AudioProfile>(audioProfileDao) {

    fun getAudioProfile(profileId: Long) = audioProfileDao.getAudioProfile(profileId)

    fun getAllAudioProfiles() =
        audioProfileDao.getAllAudioProfiles()
}