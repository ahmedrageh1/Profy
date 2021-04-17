package com.rageh.profy.data.databse.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rageh.profy.data.databse.dao.base.BaseDao
import com.rageh.profy.data.entity.WallpaperProfile
import kotlinx.coroutines.flow.Flow


@Dao
interface WallpaperProfileDao : BaseDao<WallpaperProfile> {

    @Query("SELECT * FROM wallpaper_profiles WHERE id=:profileId")
    fun getWallpaperProfile(profileId: Long): Flow<WallpaperProfile>

    @Query("SELECT * FROM wallpaper_profiles")
    fun getAllWallpaperProfiles(): Flow<List<WallpaperProfile>>

}