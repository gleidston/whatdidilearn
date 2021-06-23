package com.meupet.whatdidilearn.data


import androidx.lifecycle.LiveData
import com.meupet.whatdidilearn.data.database.LearnedItemDao
import com.meupet.whatdidilearn.entities.LearnedItem


class LearnedItemRepository(private val dao: LearnedItemDao) {
 val learnedItems: LiveData<List<LearnedItem>> = dao.getAll()
 fun addNewItem(item: LearnedItem) {
  dao.insert(item)
 }

}