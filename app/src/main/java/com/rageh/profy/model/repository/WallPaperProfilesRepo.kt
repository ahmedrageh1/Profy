package com.rageh.profy.model.repository

import com.rageh.profy.model.databse.dao.WallpaperProfileDao
import com.rageh.profy.model.entity.WallpaperProfile
import com.rageh.profy.model.repository.base.BaseRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WallPaperProfilesRepo @Inject constructor(private val wallpaperProfileDao: WallpaperProfileDao) :
    BaseRepo<WallpaperProfile>(wallpaperProfileDao) {

    fun getWallPaperProfile(profileId: Long) = wallpaperProfileDao.getWallpaperProfile(profileId)

    fun getAllWallPaperProfiles() =
        wallpaperProfileDao.getAllWallpaperProfiles()
}