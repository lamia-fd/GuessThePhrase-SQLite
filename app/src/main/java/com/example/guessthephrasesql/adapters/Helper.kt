package com.example.guessthephrasesql.adapters

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.random.Random
import kotlin.random.nextInt

class Helper(context: Context): SQLiteOpenHelper(context,"phrase.db",null,1) {
    var SOLiteDatabase: SQLiteDatabase = writableDatabase
    override fun onCreate(p: SQLiteDatabase?) {
        if (p != null) {
            p.execSQL("create table phrases (id INTEGER PRIMARY KEY,phrase text)")

        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


    fun addPhrase(phrase: String): Long {

        val cv = ContentValues()
        cv.put("phrase", phrase)
        var status = SOLiteDatabase.insert("phrases", null, cv)
        return status
    }

    @SuppressLint("Range")
    fun getPhrases(): String? {
        //   var c=SOLiteDatabase.query("phrases",null,"phrase=?", arrayOf(id),null,null,null)
        var num = this.readableDatabase.rawQuery("select * FROM phrases", null)

        var rNum = Random.nextInt(1..num.count)
        var id: Int = rNum
        println(rNum)
        println(id)
        var c = this.readableDatabase.rawQuery("select * from phrases where id=$id", null)

        c.moveToFirst()
        return c.getString(c.getColumnIndex("phrase"))

    }
}