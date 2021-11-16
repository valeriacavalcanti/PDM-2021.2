package com.example.baseadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TarefaAdapter (var contexto: Context, var lista: ArrayList<Tarefa>) : BaseAdapter() {

    override fun getCount(): Int {
        return this.lista.count()
    }

    override fun getItem(position: Int): Any {
        return this.lista.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = if (convertView == null){
            LayoutInflater.from(this.contexto).inflate(R.layout.tarefa_layout, parent, false)
        }else{
            convertView
        }

        val tarefa = this.lista.get(position)

        val tvDescricao = view.findViewById<TextView>(R.id.tvTarefaDecricao)
        val tvNota = view.findViewById<TextView>(R.id.tvTarefaNota)

        tvDescricao.text = tarefa.descricao
        tvNota.text = "Nota: ${tarefa.nota}"

        view.minimumHeight = 100

        return view
    }
}