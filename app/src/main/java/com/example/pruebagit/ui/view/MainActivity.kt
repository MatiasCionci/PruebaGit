package com.example.pruebagit.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.pruebagit.databinding.ActivityMainBinding
import com.example.pruebagit.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {


    private val quoteViewModel:QuoteViewModel by viewModels()
    private lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        //cuando alla un cambiuo live data esta como observer y va  hacer lo que pongamos aca
        quoteViewModel.quoteModel.observe(this, Observer{
            binding.tvQuote.text = it.quote
            binding.tvAutor.text = it.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible=it
        })
        //al ponerle una id al containerlayout podemos usarla como button
        binding.viewContainer.setOnClickListener {quoteViewModel.randomQuote()
        }
    }
}