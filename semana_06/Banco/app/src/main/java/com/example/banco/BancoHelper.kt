package com.example.banco

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper(context: Context): SQLiteOpenHelper(context, "dados", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table tarefas(" +
                    "id integer primary key autoincrement, " +
                    "descricao text, " +
                    "nota integer)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table tarefas")
        this.onCreate(db)
    }
}