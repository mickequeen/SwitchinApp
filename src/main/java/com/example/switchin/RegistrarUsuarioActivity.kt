package com.example.switchin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class RegistrarUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)

        val btn_registrarse = findViewById<Button>(R.id.btn_registrarse)

        btn_registrarse.setOnClickListener{
            val intent = Intent(this@RegistrarUsuarioActivity, ListadoColeccionActivity::class.java )
            Toast.makeText( this,"Registrado con éxito", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}