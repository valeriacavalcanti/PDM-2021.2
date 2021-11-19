package com.example.banco

import android.content.ContentValues
import android.content.Context

class TarefaDAO {
    private var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert(tarefa: Tarefa){
        val cv = ContentValues()
        cv.put("descricao", tarefa.descricao)
        cv.put("nota", tarefa.nota)
        this.banco.writableDatabase.insert("tarefas", null, cv)
    }

    fun count(): Int{
        val sql = "select count(id) from tarefas"
        val cursor = this.banco.readableDatabase.rawQuery(sql,null)
        cursor.moveToFirst()
        return cursor.getInt(0)
    }

    fun get(): ArrayList<Tarefa>{
        val lista = arrayListOf<Tarefa>()
        val colunas = arrayOf("id", "descricao", "nota")

        val cursor = this.banco.readableDatabase.query("tarefas", colunas, null, null, null, null, null)
        cursor.moveToFirst()

        for (i in 1..cursor.count){
            val id = cursor.getInt(0)
            val descricao = cursor.getString(1)
            val nota = cursor.getInt(2)
            lista.add(Tarefa(id, descricao, nota))
            cursor.moveToNext()
        }

        return lista
    }

    fun get(id: Int): Tarefa?{
        val colunas = arrayOf("id", "descricao", "nota")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())

        val cursor = this.banco.readableDatabase.query("tarefas", colunas, where, pWhere, null, null, null)

        cursor.moveToFirst()

        if (cursor.count == 1){
            val id = cursor.getInt(0)
            val descricao = cursor.getString(1)
            val nota = cursor.getInt(2)
            return Tarefa(id, descricao, nota)
        }
        return null
    }

    fun delete(id: Int){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("tarefas", where, pWhere)
    }

    fun update(tarefa: Tarefa){
        val where = "id = ?"
        val pWhere = arrayOf(tarefa.id.toString())
        val cv = ContentValues()
        cv.put("descricao", tarefa.descricao)
        cv.put("nota", tarefa.nota)

        this.banco.writableDatabase.update("tarefas", cv, where, pWhere)
    }
}