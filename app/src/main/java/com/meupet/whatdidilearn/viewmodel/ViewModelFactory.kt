package com.meupet.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.meupet.whatdidilearn.data.LearnedItemRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: LearnedItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("uknow view model class ")
    }
}