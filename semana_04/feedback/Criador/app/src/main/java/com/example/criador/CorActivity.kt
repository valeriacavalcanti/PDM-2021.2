package com.example.criador

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView

class CorActivity : AppCompatActivity() {
    private lateinit var preview: View
    private lateinit var sbRed: SeekBar
    private lateinit var sbGreen: SeekBar
    private lateinit var sbBlue: SeekBar
    private lateinit var tvRed: TextView
    private lateinit var tvGreen: TextView
    private lateinit var tvBlue: TextView
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cor)

        this.preview = findViewById(R.id.vCorPreview)

        this.sbRed = findViewById(R.id.sbCorRed)
        this.sbGreen = findViewById(R.id.sbCorGreen)
        this.sbBlue = findViewById(R.id.sbCorBlue)

        this.tvRed = findViewById(R.id.tvCorRed)
        this.tvGreen = findViewById(R.id.tvCorGreen)
        this.tvBlue = findViewById(R.id.tvCorBlue)

        this.btSalvar = findViewById(R.id.btCorSalvar)
        this.btCancelar = findViewById(R.id.btCorCancelar)

        this.sbRed.setOnSeekBarChangeListener(SeekCor())
        this.sbGreen.setOnSeekBarChangeListener(SeekCor())
        this.sbBlue.setOnSeekBarChangeListener(SeekCor())

        this.btSalvar.setOnClickListener{ salvar() }
        this.btCancelar.setOnClickListener{ finish() }
    }

    private fun getCor(): Int {
        val red = this.sbRed.progress
        val green = this.sbGreen.progress
        val blue = this.sbBlue.progress
        return Color.rgb(red, green, blue)
    }

    private fun salvar(){
        val cor = this.preview.solidColor
        val intent = Intent().apply {
            putExtra("COR", this@CorActivity.getCor())
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    inner class SeekCor: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            val cor = this@CorActivity.getCor()
            this@CorActivity.preview.setBackgroundColor(cor)
            this@CorActivity.tvRed.text = Color.red(cor).toString()
            this@CorActivity.tvGreen.text = Color.green(cor).toString()
            this@CorActivity.tvBlue.text = Color.blue(cor).toString()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }
}