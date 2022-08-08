package com.example.pruebagit.data.model.network

import com.example.pruebagit.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET


interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuote():Response<List<QuoteModel>>
}