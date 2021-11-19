package com.example.banco

class Tarefa {
    val id: Int
    var descricao: String
    var nota: Int

    constructor(descricao: String, nota: Int){
        this.id = -1
        this.descricao = descricao
        this.nota = nota
    }

    constructor(id: Int, descricao: String, nota: Int){
        this.id = id
        this.descricao = descricao
        this.nota = nota
    }

    override fun toString(): String {
        return "$descricao - $nota"
    }
}