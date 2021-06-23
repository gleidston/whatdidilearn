package com.meupet.whatdidilearn.data.database

import androidx.room.TypeConverter
import com.meupet.whatdidilearn.entities.UndestandingLevel

class Converters {
     @TypeConverter
     fun levelToInt(level: UndestandingLevel):Int{

         return level.ordinal
     }

    @TypeConverter
    fun intToLevel (int: Int): UndestandingLevel {
        return when(int){
        UndestandingLevel.Low.ordinal-> UndestandingLevel.Low
            UndestandingLevel.Medium.ordinal-> UndestandingLevel.Medium


            else -> UndestandingLevel.High
        }
    }
}