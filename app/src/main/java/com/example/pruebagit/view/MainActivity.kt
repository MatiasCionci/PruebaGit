package com.example.pruebagit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.pruebagit.R
import com.example.pruebagit.databinding.ActivityMainBinding
import com.example.pruebagit.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private val quoteViewModel:QuoteViewModel by viewModels()
    private lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        //cuando alla un cambiuo live data esta como observer y va  hacer lo que pongamos aca
        quoteViewModel.quoteModel.observe(this, Observer { currenteQuote ->
            binding.tvQuote.text = currenteQuote.quote
            binding.tvAutor.text = currenteQuote.autor
        })

        //al ponerle una id al containerlayout podemos usarla como button
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}