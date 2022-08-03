package com.example.pruebagit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebagit.model.QuoteModel
import com.example.pruebagit.model.QuoteProvider

class QuoteViewModel:ViewModel() {
    val quoteModel=MutableLiveData<QuoteModel>()
    fun randomQuote(){
        //valor random del repositorio y se lo seteamos a quote conectado con la activity
        var currentQuote:QuoteModel=QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}