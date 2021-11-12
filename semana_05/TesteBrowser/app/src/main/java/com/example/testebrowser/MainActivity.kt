package com.example.testebrowser

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etEndereco: EditText
    private lateinit var btVer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etEndereco = findViewById(R.id.etEndereco)
        this.btVer = findViewById(R.id.btVer)

        this.btVer.setOnClickListener{ ver() }
    }

    private fun ver(){
        val endereco = this.etEndereco.text.toString()
        val uri = Uri.parse(endereco)

        val intent = Intent(Intent.ACTION_VIEW, uri)
        //val intent = Intent("IFBROWSER", uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
        }
    }
}