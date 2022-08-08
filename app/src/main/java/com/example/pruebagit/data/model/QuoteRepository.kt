package com.example.pruebagit.data.model

import com.example.pruebagit.data.model.network.QuoteService

//servidor de backend
class QuoteRepository {
    private val api =QuoteService()
    suspend fun  getAlQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}