package com.rageh.profy.model.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.model.databse.dao.base.BaseDao
import com.rageh.profy.model.entity.WallpaperProfile


@Dao
interface WallpaperProfileDao : BaseDao<WallpaperProfile> {

    @Query("SELECT * FROM wallpaper_profiles WHERE id=:profileId")
    fun getWallpaperProfile(profileId: Long): LiveData<WallpaperProfile>

    @Query("SELECT * FROM wallpaper_profiles")
    fun getAllWallpaperProfiles(): LiveData<List<WallpaperProfile>>

}