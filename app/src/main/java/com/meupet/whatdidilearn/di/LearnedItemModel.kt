package com.meupet.whatdidilearn.di


import com.meupet.whatdidilearn.data.LearnedItemRepository
import com.meupet.whatdidilearn.data.database.LearnItemDatabase
import com.meupet.whatdidilearn.entities.LearnedItem
import com.meupet.whatdidilearn.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LearnedItemModel {
    val module = module {
     factory { CoroutineScope(Dispatchers.IO)


     }
        factory {
            LearnedItemRepository(get())

        }
        single {

        LearnItemDatabase.getDatabase(context = get() ,scope = get())

        }
        single {

            get<LearnItemDatabase>().learnedItemDao()
        }
        viewModel {

            MainViewModel(get())
        }
    }
}