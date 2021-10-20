package com.example.aposta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var numeros: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.numeros = findViewById(R.id.tvNumeros)
        this.numeros.text = this.gerarNumeros()
    }

    fun gerarNumeros(): String{
        var lista:MutableSet<Int> = mutableSetOf()

        while(lista.size < 6){
            lista.add(Random.nextInt(1,61))
        }

        return lista.toString()
    }
}