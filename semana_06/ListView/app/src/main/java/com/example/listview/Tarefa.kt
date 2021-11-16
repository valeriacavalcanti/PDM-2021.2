package com.example.listview

import java.io.Serializable

class Tarefa (var descricao: String, var nota: Int): Serializable{
    override fun toString(): String {
        return "$descricao ($nota)"
    }
}