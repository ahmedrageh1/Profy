package com.rageh.profy.data.repository

import com.rageh.profy.data.databse.dao.WallpaperProfileDao
import com.rageh.profy.data.entity.WallpaperProfile
import com.rageh.profy.data.repository.base.BaseRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WallPaperProfilesRepo @Inject constructor(private val wallpaperProfileDao: WallpaperProfileDao) :
    BaseRepo<WallpaperProfile>(wallpaperProfileDao) {

    fun getWallPaperProfile(profileId: Long) = wallpaperProfileDao.getWallpaperProfile(profileId)

    fun getAllWallPaperProfiles() =
        wallpaperProfileDao.getAllWallpaperProfiles()
}