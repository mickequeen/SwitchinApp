package com.example.switchin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_registro = findViewById<Button>(R.id.btn_registrar)

        btn_login.setOnClickListener{
            if ( validacionCampos() == 0){
                val intent = Intent(this@MainActivity, ListadoColeccionActivity::class.java )
                Toast.makeText( this, "bienvenido/a!" , Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        btn_registro.setOnClickListener{
            val intent = Intent(this@MainActivity, RegistrarUsuarioActivity::class.java)
            startActivity(intent)
        }
    }
    fun validacionCampos(): Int{
        val til_nombre_usuario = findViewById<TextInputLayout>(R.id.nombre_usuario)
        val til_clave_usu = findViewById<TextInputLayout>(R.id.clave_usuario)
        var nombre_usuario = til_nombre_usuario.editText?.text.toString()
        var clave = til_clave_usu.editText?.text.toString()
        val validador = Validador()
        var contador = 0
        // validación usuario
        if(!validador.validarNull(nombre_usuario) && validador.validarNombreUsu(nombre_usuario)){
            til_nombre_usuario.error = "Nombre de usuario inválido"
            contador++
        }  else if (validador.validarNull(nombre_usuario) && validador.validarNombreUsu(nombre_usuario)){
            til_nombre_usuario.error = getString(R.string.error_campo_requerido)
            contador++
        } else if (!validador.validarNull(nombre_usuario) && !validador.validarNombreUsu(nombre_usuario)){
            til_nombre_usuario.error = ""
        }
        //validación contraseña
        if (!validador.validarNull(clave) && validador.validarLargoClave(clave)){
            til_clave_usu.error = "Largo de contraseña no válido"
            contador++
        } else if (validador.validarNull(clave) && validador.validarLargoClave(clave)) {
            til_clave_usu.error = getString(R.string.error_campo_requerido)
            contador++
        } else {
            til_nombre_usuario.error = ""
        }
        return contador
    }

    // funciones ciclo de vida de la app
    override fun onDestroy() {
        //Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
        println("onDestroy")
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        //Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
        println("onStart")
    }
    override fun onResume() {
        super.onResume()
        //Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
        println("onResume")
    }
    override fun onRestart() {
        super.onRestart()
        //Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
        println("onRestart")
    }
    override fun onPause() {
        //Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        //Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
        super.onStop()
        println("onStop")
    }

}