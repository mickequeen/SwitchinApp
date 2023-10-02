package com.example.switchin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast

class ListadoColeccionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_coleccion)

        val lista_coleccion = findViewById<ListView>(R.id.lista_coleccion)
        val agregar_item = findViewById<ImageButton>(R.id.agregar_item)
        val volver_inicio = findViewById<ImageButton>(R.id.volver_inicio)

        lista_coleccion.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val intent = Intent(this@ListadoColeccionActivity, ActualizarEliminarJuegoActivity::class.java )
                startActivity(intent)
            }
        }
        agregar_item.setOnClickListener{
            val intent = Intent(this@ListadoColeccionActivity,  NuevoJuegoActivity::class.java)
            startActivity(intent)
        }
        volver_inicio.setOnClickListener{
            val intent = Intent(this@ListadoColeccionActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}