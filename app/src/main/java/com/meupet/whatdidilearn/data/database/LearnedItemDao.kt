package com.meupet.whatdidilearn.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meupet.whatdidilearn.entities.LearnedItem

@Dao
interface LearnedItemDao {

     @Query("Select * From learned_item")
    fun getAll(): LiveData<List <LearnedItem>>
     @Insert
    fun insert(item: LearnedItem)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(learnedItems: List<LearnedItem>)

}

