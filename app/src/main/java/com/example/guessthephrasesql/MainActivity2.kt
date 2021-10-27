package com.example.guessthephrasesql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.guessthephrasesql.adapters.Helper

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val et = findViewById<EditText>(R.id.et)
        val but = findViewById<Button>(R.id.button)

        but.setOnClickListener {
            var phrase = et.text.toString()
            var dbh = Helper(applicationContext)
            var status = dbh.addPhrase(phrase)
            if(status>0) {
                Toast.makeText(applicationContext, "data is served", Toast.LENGTH_LONG).show()
            }else if (status<0){
                Toast.makeText(applicationContext, "fail to serve", Toast.LENGTH_LONG).show()

            }





        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        var item: MenuItem =menu!!.getItem(0)
        menu?.removeItem(R.id.add)
        return super.onPrepareOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.game -> {

                var intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            R.id.add -> {
                var intent= Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}