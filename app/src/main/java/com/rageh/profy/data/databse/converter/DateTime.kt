package com.rageh.profy.data.databse.converter

import androidx.room.TypeConverter
import java.util.*

class DateTime {
    companion object {
        @JvmStatic
        @TypeConverter
        fun fromTimestamp(value: Long?): Date? {
            return value?.let { Date(it) }
        }

        @JvmStatic
        @TypeConverter
        fun dateToTimestamp(date: Date?): Long? {
            return date?.time
        }
    }
}