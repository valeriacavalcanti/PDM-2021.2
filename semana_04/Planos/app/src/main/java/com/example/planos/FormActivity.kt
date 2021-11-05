package com.example.planos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var etNota: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.etNota = findViewById(R.id.etFormNota)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener{ salvar() }
        this.btCancelar.setOnClickListener{ finish() }
    }

    private fun salvar() {
        val descricao = this.etDescricao.text.toString()
        val nota = this.etNota.text.toString().toInt()
        val plano = Plano(descricao, nota)

        val intent = Intent().apply {
            putExtra("PLANO", plano)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}