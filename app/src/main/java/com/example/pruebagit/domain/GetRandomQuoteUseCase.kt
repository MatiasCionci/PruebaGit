package com.example.pruebagit.domain

import com.example.pruebagit.data.model.QuoteModel
import com.example.pruebagit.data.model.QuoteProvider
import com.example.pruebagit.data.model.QuoteRepository

class GetRandomQuoteUseCase {
    private val repository = QuoteRepository()
    operator fun invoke():QuoteModel?{
        val quotes:List<QuoteModel> =QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size-1).random()
            return quotes[randomNumber]
        }
        return null

    }
}