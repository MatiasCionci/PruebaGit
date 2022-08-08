package com.example.pruebagit.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.pruebagit.data.model.QuoteModel
import com.example.pruebagit.data.model.QuoteProvider
import com.example.pruebagit.domain.GetQuoteUseCase
import com.example.pruebagit.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel:ViewModel() {
    val quoteModel=MutableLiveData<QuoteModel>()
    //va a manejar el progresbarr
    val isLoading = MutableLiveData<Boolean>()
//llamada al caso de uso
    var getQuoteUseCase = GetQuoteUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()
    fun onCreate() {
        //coroutine que s e controla automaticamente
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<QuoteModel>? = getQuoteUseCase()
            if(!result.isNullOrEmpty()){
                //cuando arranque la app si la lista no es vacia settia el primer valor de la list
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote:QuoteModel? =getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }

}