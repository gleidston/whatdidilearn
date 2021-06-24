package com.meupet.whatdidilearn.view

import android.app.Application
import com.meupet.whatdidilearn.di.LearnedItemModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class WhatdidILearnApplication : Application() {
/* // esse trecho do codigo mostra como fazer injeçao de dependencia sem o koin

    val database by lazy { LearnItemDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO)) }

    val repository by lazy {

        LearnedItemRepository(database.learnedItemDao())
    }
*/

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WhatdidILearnApplication)
            modules(LearnedItemModel.module)
        }
    }
}