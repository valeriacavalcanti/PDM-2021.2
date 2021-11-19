package com.example.banco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var etNota: EditText
    private lateinit var btSalvar: Button
    private lateinit var lvTarefas: ListView
    private lateinit var dao: TarefaDAO
    private lateinit var lista: ArrayList<Tarefa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dao = TarefaDAO(this)

        this.etDescricao = findViewById(R.id.etDescricao)
        this.etNota = findViewById(R.id.etNota)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.lvTarefas = findViewById(R.id.lvTarefas)

        this.btSalvar.setOnClickListener{ salvar() }
        this.atualiza()

        this.lvTarefas.setOnItemClickListener(OnItem())
        this.lvTarefas.setOnItemLongClickListener(OnLongItem())
    }

    fun atualiza(){
        this.lista = this.dao.get()
        this.lvTarefas.adapter = ArrayAdapter<Tarefa>(this, android.R.layout.simple_list_item_1, this.lista)
    }

    fun salvar(){
        val descricao = this.etDescricao.text.toString()
        val nota = this.etNota.text.toString().toInt()
        val tarefa = Tarefa(descricao, nota)

        // salvar no banco
        this.dao.insert(tarefa)

        // apresentar a quantidade de registros no log
        Log.i("APP_BANCO", this.dao.count().toString())

        // apresentar a lista no listview
        this.atualiza()
    }

    inner class OnItem: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val id = this@MainActivity.lista.get(position).id
            //Toast.makeText(this@MainActivity, tarefa.descricao, Toast.LENGTH_SHORT).show()
            val tarefa = this@MainActivity.dao.get(id)
            tarefa?.nota = tarefa?.nota!! * 2
            this@MainActivity.dao.update(tarefa)
            this@MainActivity.atualiza()
        }
    }

    inner class OnLongItem: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long,
        ): Boolean {
            val tarefa = this@MainActivity.lista.get(position)
            this@MainActivity.dao.delete(tarefa.id)
            this@MainActivity.atualiza()
            return true
        }

    }
}