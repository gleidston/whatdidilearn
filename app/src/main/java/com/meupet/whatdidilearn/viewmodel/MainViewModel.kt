package com.meupet.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.meupet.whatdidilearn.data.LearnedItemRepository
import com.meupet.whatdidilearn.entities.LearnedItem

class MainViewModel(private val repository: LearnedItemRepository) : ViewModel() {
    val learnedItems: LiveData<List<LearnedItem>> = repository.learnedItems

}