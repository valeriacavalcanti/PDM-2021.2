package com.example.baseadapter

import java.io.Serializable
import java.util.*

class Tarefa (var descricao: String, var nota: Int): Serializable{
    override fun toString(): String {
        return "$descricao ($nota)"
    }
}