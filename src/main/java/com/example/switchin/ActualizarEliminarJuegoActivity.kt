package com.example.switchin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActualizarEliminarJuegoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_eliminar_juego)

        val btn_eliminar = findViewById<Button>(R.id.btn_eliminar)
        val btn_actualizar = findViewById<Button>(R.id.btn_actualizar)

        btn_eliminar.setOnClickListener{
            val intent = Intent(this@ActualizarEliminarJuegoActivity, ListadoColeccionActivity::class.java )
            Toast.makeText( this,"Item Eliminado", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        btn_actualizar.setOnClickListener{
            val intent = Intent(this@ActualizarEliminarJuegoActivity, ListadoColeccionActivity::class.java)
            Toast.makeText( this,"Item Actualizado", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}