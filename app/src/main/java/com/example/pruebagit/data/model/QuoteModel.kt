package com.example.pruebagit.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(@SerializedName("quate")val quote:String,@SerializedName("author") val author:String)