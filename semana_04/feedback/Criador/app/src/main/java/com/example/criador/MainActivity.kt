package com.example.criador

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import org.jetbrains.annotations.Contract

class MainActivity : AppCompatActivity() {
    private lateinit var tvCor: TextView
    private lateinit var btNova: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvCor = findViewById(R.id.tvMainCor)
        this.btNova = findViewById(R.id.btMainNova)

        val resultCor = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val cor = it.data?.getIntExtra("COR", 0)!!
                this.tvCor.setBackgroundColor(cor)
                this.tvCor.text = "#%02X%02X%02X".format(Color.red(cor), Color.green(cor), Color.blue(cor))
            }
        }

        this.btNova.setOnClickListener{
            resultCor.launch(Intent(this, CorActivity::class.java))
        }
    }
}