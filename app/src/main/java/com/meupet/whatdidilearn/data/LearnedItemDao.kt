package com.meupet.whatdidilearn.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LearnedItemDao {

     @Query("Select * From learned_item")
    fun getAll():List <LearnedItem>
     @Insert
    fun isnert(item: LearnedItem)

}

