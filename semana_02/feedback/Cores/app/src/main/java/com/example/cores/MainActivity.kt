package com.example.cores

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var layout: ConstraintLayout
    private lateinit var tvCor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.layout = findViewById(R.id.layout)
        this.tvCor = findViewById(R.id.tvCor)

        this.layout.setOnClickListener{
            this.novaCor()
        }
    }

    private fun novaCor(){
        // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/next-int.html
        val red = Random.nextInt(0, 256)
        val green = Random.nextInt(0, 256)
        val blue = Random.nextInt(0, 256)
        this.layout.setBackgroundColor(Color.rgb(red, green, blue))
        this.tvCor.text = "$red.$green.$blue"
    }
}