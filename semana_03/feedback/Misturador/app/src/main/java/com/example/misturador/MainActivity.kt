package com.example.misturador

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var tvCor: TextView
    private lateinit var sbRed: SeekBar
    private lateinit var sbGreen: SeekBar
    private lateinit var sbBlue: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvCor = findViewById(R.id.tvCor)
        this.sbRed = findViewById(R.id.sbRed)
        this.sbGreen = findViewById(R.id.sbGreen)
        this.sbBlue = findViewById(R.id.sbBlue)

        this.sbRed.setOnSeekBarChangeListener(SeekCor())
        this.sbGreen.setOnSeekBarChangeListener(SeekCor())
        this.sbBlue.setOnSeekBarChangeListener(SeekCor())

        this.sbRed.progress = Random.nextInt(0, 256)
        this.sbGreen.progress = Random.nextInt(0, 256)
        this.sbBlue.progress = Random.nextInt(0, 256)

        this.setCor()
    }

    private fun setCor(){
        val cor = Color.rgb(this.sbRed.progress, this.sbGreen.progress, this.sbBlue.progress)
        this.tvCor.setBackgroundColor(cor)
        val sRed = "%02X".format(this.sbRed.progress)
        val sGreen = "%02X".format(this.sbGreen.progress)
        val sBlue = "%02X".format(this.sbBlue.progress)
        this.tvCor.text = "$sRed$sGreen$sBlue"
    }

    inner class SeekCor: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this@MainActivity.setCor()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }
}