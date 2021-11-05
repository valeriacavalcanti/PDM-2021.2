package com.example.planos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class SobreActivity : AppCompatActivity() {
    private lateinit var layout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        Log.i("APP_PLANOS", "sobre - onCreate")

        if (intent.hasExtra("AMANDA")){
            val msg = intent.getStringExtra("AMANDA")
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        this.layout = findViewById(R.id.layoutSobre)

        this.layout.setOnClickListener{
            this.finish()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_PLANOS", "sobre - onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_PLANOS", "sobre - onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_PLANOS", "sobre - onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_PLANOS", "sobre - onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_PLANOS", "sobre - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_PLANOS", "sobre - onDestroy")
    }
}