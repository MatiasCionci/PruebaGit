package com.example.pruebagit.domain

import com.example.pruebagit.data.model.QuoteModel
import com.example.pruebagit.data.model.QuoteRepository

class GetQuoteUseCase {
    private val repository = QuoteRepository()
    //constructor que devuelve una lista
    suspend operator fun invoke():List<QuoteModel>? = repository.getAlQuotes()
    }
