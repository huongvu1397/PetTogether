package com.devhwang.a84974.pettogether.data

import android.arch.persistence.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter fun calendatToDatestamp(calendar: Calendar):Long = calendar.timeInMillis

    @TypeConverter fun datestampToCalendar(value: Long): Calendar =
        Calendar.getInstance().apply { timeInMillis = value }

}