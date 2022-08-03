package com.example.pruebagit.model

class QuoteProvider {
    //companion es una clas estatica de java
    companion object {

     fun random():QuoteModel{
         val position=(0..7).random()
         return quote[position]
     }
     private val quote = listOf<QuoteModel>(
            QuoteModel(
                quote = "Con trabajo duro se logra el premio",
                autor = "Fuck System"
            ),
            QuoteModel(
                quote = "Por mas que la vida te pegue duro Jamas te rindas",
                autor = "Fuck System"
            )
        )
    }

}

