package com.rageh.profy.data.entity

import androidx.annotation.IntDef
import androidx.databinding.BaseObservable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rageh.profy.data.entity.skeleton.IdentifiedItem
import java.util.*


@Entity(tableName = "profile_triggers")
data class ProfileTrigger(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @TriggerType
    @ColumnInfo(name = "type")
    val type: Int,
    @ColumnInfo(name = "name")
    val name: String? = null,
    @ColumnInfo(name = "mac_address")
    val macAddress: String? = null,
    @ColumnInfo(name = "latitude")
    val latitude: Double? = null,
    @ColumnInfo(name = "longitude")
    val longitude: Double? = null,
    @ColumnInfo(name = "range")
    val range: Float? = null,
    @ColumnInfo(name = "time")
    val time: Date? = null,
    @ColumnInfo(name = "week_days")
    var weekDaysFrom: Int = 0, //7 bits for 7 week days (max value 127)
    @ColumnInfo(name = "repeat_weekly")
    val repeatWeekly: Boolean = false
) : BaseObservable(), IdentifiedItem {

    override fun getIdentifier() = id

    fun onDayTriggered(dayBit: Int) {
        weekDaysFrom = weekDaysFrom xor dayBit
    }

    companion object {
        const val TRIGGER_TYPE_TIME = 1
        const val TRIGGER_TYPE_BLUETOOTH = 2
        const val TRIGGER_TYPE_WIFI = 3
        const val TRIGGER_TYPE_LOCATION = 4
        const val TRIGGER_TYPE_URL = 5

    }

    @IntDef(
        TRIGGER_TYPE_TIME,
        TRIGGER_TYPE_BLUETOOTH,
        TRIGGER_TYPE_WIFI,
        TRIGGER_TYPE_LOCATION,
        TRIGGER_TYPE_URL
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class TriggerType
}