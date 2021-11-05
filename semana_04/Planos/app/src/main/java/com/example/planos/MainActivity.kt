package com.example.planos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var tvDescricao: TextView
    private lateinit var tvNota: TextView
    private lateinit var btAdd: Button
    private lateinit var btSobre: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("APP_PLANOS", "main - onCreate")

        this.tvDescricao = findViewById(R.id.tvMainDescricao)
        this.tvNota = findViewById(R.id.tvMainNota)
        this.btAdd = findViewById(R.id.btMainAdd)
        this.btSobre = findViewById(R.id.btMainSobre)

        val formResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            // novo plano
            if (it.resultCode == RESULT_OK){
                val plano = it.data?.getSerializableExtra("PLANO") as Plano
                this.tvDescricao.text = plano.descricao
                this.tvNota.text = plano.nota.toString()
            }else{
                Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
            }
        }

        this.btAdd.setOnClickListener{
            val intent = Intent(this, FormActivity::class.java)
            formResult.launch(intent)
        }

        this.btSobre.setOnClickListener{
            val intent = Intent(this, SobreActivity::class.java).apply {
                putExtra("AMANDA", "Alô Mundo!")
            }

            //intent.putExtra("AMANDA", "Alô Mundo!")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_PLANOS", "main - onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_PLANOS", "main - onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_PLANOS", "main - onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_PLANOS", "main - onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_PLANOS", "main - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_PLANOS", "main - onDestroy")
    }
}