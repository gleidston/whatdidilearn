package com.meupet.whatdidilearn.data;

import java.util.List;

public class LearnedItemDatabase {
    public fun getAll():List<LearnedItem>{

           {
        return listOf(
                LearnedItem(name = "Kotlin", description  = "Linguagem kotlin para Android", understandingLevel = UndestandingLevel.High),
                LearnedItem(name = "RecyclerView", description  = "Listas em Android", understandingLevel = UndestandingLevel.Medium),
                LearnedItem(name = "DataClass", description = "Kotlin data Class", understandingLevel = UndestandingLevel.Low),
                LearnedItem(name = "Life Cycle", description = "Ciclo de vida de uma aplicação Android", understandingLevel= UndestandingLevel.High),
                LearnedItem(name = "Intent", description = "Como usar intents", understandingLevel = UndestandingLevel.Medium),
                LearnedItem(name = "Services", description = "Service em  Android", understandingLevel = UndestandingLevel.Medium),
                LearnedItem(name = "Content Provider", description = "Dados com Contenct Provider", understandingLevel= UndestandingLevel.Low)
        )
        )

    }
    }



}


