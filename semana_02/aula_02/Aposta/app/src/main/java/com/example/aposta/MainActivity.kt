package com.example.aposta

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var numeros: TextView
    private lateinit var btNova: Button
    private lateinit var layout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.numeros = findViewById(R.id.tvNumeros)
        this.btNova = findViewById(R.id.btNova)
        this.layout = findViewById(R.id.layout)

        //this.novaAposta()

        // método 01: inserir onclick no xml  :-(

        // método 02
        this.layout.setOnClickListener{
            this.numeros.text = "Nova aposta"
            this.numeros.setBackgroundColor(Color.GREEN)
        }

        // método 03
        this.btNova.setOnClickListener(BotaoListener())
        this.btNova.setOnLongClickListener(BotaoLongoListener())
    }

    fun gerarNumeros(): String{
        var lista:MutableSet<Int> = mutableSetOf()

        while(lista.size < 6){
            lista.add(Random.nextInt(1,61))
        }

        return lista.toString()
    }

    fun novaAposta(){
        this.numeros.text = this.gerarNumeros()
    }

    inner class BotaoListener: View.OnClickListener{
        override fun onClick(v: View?) {
            this@MainActivity.novaAposta()
        }
    }

    inner class BotaoLongoListener: View.OnLongClickListener{
        override fun onLongClick(v: View?): Boolean {
            this@MainActivity.numeros.text = "IFPB"
            return true
        }
    }
}