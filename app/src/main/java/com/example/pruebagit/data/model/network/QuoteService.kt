package com.example.pruebagit.data.model.network

import com.example.pruebagit.core.RetrofitHelper
import com.example.pruebagit.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

//Clase encargada del servicio de internet Principio Solid
class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes():List<QuoteModel> {
        //coroutine para no sobre cargar el hilo principal
        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> =
                retrofit.create(QuoteApiClient::class.java).getAllQuote()
                response.body() ?: emptyList()//si response es null devuelve list vacia
        }


    }
}