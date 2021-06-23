package com.meupet.whatdidilearn.view

import android.app.Application
import com.meupet.whatdidilearn.data.database.LearnItemDatabase
import com.meupet.whatdidilearn.data.LearnedItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class WhatdidILearnApplication : Application() {
    val database by lazy { LearnItemDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO)) }

    val repository by lazy {

        LearnedItemRepository(database.learnedItemDao())
    }
}