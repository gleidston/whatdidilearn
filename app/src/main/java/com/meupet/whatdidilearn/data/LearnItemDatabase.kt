package com.meupet.whatdidilearn.data

import android.content.Context
import android.provider.CalendarContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [LearnedItem::class],version = 1,exportSchema = false)
@TypeConverters(Converters::class)

abstract class LearnItemDatabase :RoomDatabase(){

     abstract fun learnedItemDao ():LearnedItemDao
     companion object{

         @Volatile
         var INSTANCE : LearnItemDatabase? = null

         fun getDatabase(context: Context):LearnItemDatabase{
             return INSTANCE ?: synchronized(this){

                 val database = Room.databaseBuilder(context.applicationContext,LearnItemDatabase::class.java
                 ,"learned_item_database").build()
                 INSTANCE=database
                 database
             }
         }



     }




     fun getAll():List<LearnedItem>{
          return listOf(
                LearnedItem(name = "Kotlin", description  = "Linguagem kotlin para Android", understandingLevel = UndestandingLevel.High),
                LearnedItem(name = "RecyclerView", description  = "Listas em Android", understandingLevel = UndestandingLevel.Medium),
                LearnedItem(name = "DataClass", description = "Kotlin data Class", understandingLevel = UndestandingLevel.Low),
                LearnedItem(name = "Life Cycle", description = "Ciclo de vida de uma aplicação Android", understandingLevel= UndestandingLevel.High),
                LearnedItem(name = "Intent", description = "Como usar intents", understandingLevel = UndestandingLevel.Medium),
                LearnedItem(name = "Services", description = "Service em  Android", understandingLevel = UndestandingLevel.Medium),
                LearnedItem(name = "Content Provider", description = "Dados com Contenct Provider", understandingLevel= UndestandingLevel.Low)
            )


        }
}