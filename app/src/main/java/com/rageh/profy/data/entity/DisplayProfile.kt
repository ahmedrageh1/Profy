package com.rageh.profy.data.entity

import androidx.annotation.IntRange
import androidx.databinding.BaseObservable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rageh.profy.data.entity.skeleton.IdentifiedItem
import kotlin.math.log2

/**
 * Created by Ahmed on 2/27/2019.
 */
@Entity(
    tableName = "display_profiles"
)
data class DisplayProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "screen_auto_brightness")
    var screenAutoBrightness: Boolean,
    @ColumnInfo(name = "screen_brightness")
    var screenBrightness: Int,
    @ColumnInfo(name = "screen_off_timeout")
    var screenOffTimeout: Int,
    @ColumnInfo(name = "screen_auto_rotation")
    var screenAutoRotation: Boolean
) : BaseObservable(), IdentifiedItem {

    fun getDiscreteBrightnessLevel() = log2(screenBrightness - 19.0).toInt()
    fun setDiscreteBrightnessLevel(@IntRange(from = 0L, to = 8L) discreteLevel: Int) {
        val value = Math.pow(2.0, discreteLevel.toDouble()).toInt() + 19
        screenBrightness = if (value > 255)
            255
        else value
    }

    override fun toString(): String {
        return name
    }

    override fun getIdentifier() = id
}