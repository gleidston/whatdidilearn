package com.meupet.whatdidilearn.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.meupet.whatdidilearn.entities.LearnedItem
import com.meupet.whatdidilearn.entities.UndestandingLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [LearnedItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)

abstract class LearnItemDatabase : RoomDatabase() {

    abstract fun learnedItemDao(): LearnedItemDao

    companion object {
        // singleton para evitar multiplas isntancias do banco de dados sejam abertas ao mesmo tempo
        @Volatile
        var INSTANCE: LearnItemDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): LearnItemDatabase {

            // se instance nao e nulo , entao retorna ela mesma
            //se isntance e nula entao cria uma instancia do banco
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LearnItemDatabase::class.java,
                    "learned_item_database"
                ).addCallback(LearnedItemDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }


    }

    private class LearnedItemDatabaseCallback(private val scope: CoroutineScope) :
        RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                scope.launch { populateDatabase(it.learnedItemDao()) }
            }
            // lauch ok
        }

        fun populateDatabase(learnedItemDao: LearnedItemDao) {
            val items = getAll()
            learnedItemDao.insert(items)

        }

        fun getAll(): List<LearnedItem> {
            return listOf(
                LearnedItem(
                    name = "Kotlin",
                    description = "Linguagem kotlin para Android",
                    understandingLevel = UndestandingLevel.High
                ),
                LearnedItem(
                    name = "RecyclerView",
                    description = "Listas em Android",
                    understandingLevel = UndestandingLevel.Medium
                ),
                LearnedItem(
                    name = "DataClass",
                    description = "Kotlin data Class",
                    understandingLevel = UndestandingLevel.Low
                ),
                LearnedItem(
                    name = "Life Cycle",
                    description = "Ciclo de vida de uma aplicação Android",
                    understandingLevel = UndestandingLevel.High
                ),
                LearnedItem(
                    name = "Intent",
                    description = "Como usar intents",
                    understandingLevel = UndestandingLevel.Medium
                ),
                LearnedItem(
                    name = "Services",
                    description = "Service em  Android",
                    understandingLevel = UndestandingLevel.Medium
                ),
                LearnedItem(
                    name = "Content Provider",
                    description = "Dados com Contenct Provider",
                    understandingLevel = UndestandingLevel.Low
                )
            )


        }

    }

}