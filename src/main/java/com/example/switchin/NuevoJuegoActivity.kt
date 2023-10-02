package com.example.switchin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class NuevoJuegoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_juego)

        val btn_agregar = findViewById<Button>(R.id.btn_agregar)
        val btn_cancelar = findViewById<Button>(R.id.btn_cancelar)

        btn_agregar.setOnClickListener{
            val intent = Intent(this@NuevoJuegoActivity,  ListadoColeccionActivity::class.java)
            Toast.makeText( this,"Item Agregado", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        btn_cancelar.setOnClickListener{
            val intent = Intent(this@NuevoJuegoActivity, ListadoColeccionActivity::class.java)
            startActivity(intent)
        }
    }
}