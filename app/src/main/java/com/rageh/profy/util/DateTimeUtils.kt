package com.rageh.profy.util

import android.app.AlarmManager
import java.util.*

class DateTimeUtils {

}

fun Date.add(millis: Long) = apply { time += millis }

fun Date.getNextAlarmTime(): Date {
    val now = Date()
    return if (after(now)) this else {
        val diffWeeks = (now.time - time) / (AlarmManager.INTERVAL_DAY * 7)
        return Date((diffWeeks + 1) * AlarmManager.INTERVAL_DAY * 7 + time)
    }
}