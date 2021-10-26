package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("APP_LAYOUT", "Ok, funciona - informação")
        Log.e("APP_LAYOUT", "Ok, funciona - erro")
        Log.w("APP_LAYOUT", "Ok, funciona - aviso")

        Log.i("APP_LAYOUT", "onCreate")
    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_LAYOUT", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_LAYOUT", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_LAYOUT", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_LAYOUT", "onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_LAYOUT", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_LAYOUT", "onDestroy")
    }
}