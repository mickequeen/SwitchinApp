package com.example.switchin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

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
            if ( validacionCampos() == 0){
                val intent = Intent(this@ActualizarEliminarJuegoActivity, ListadoColeccionActivity::class.java)
                Toast.makeText( this,"Item Actualizado", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
    }
    fun validacionCampos(): Int{
        val til_nombre_juego = findViewById<TextInputLayout>(R.id.editar_nombre_juego)
        val til_estado = findViewById<Spinner>(R.id.editar_estado)
        val til_tipo = findViewById<Spinner>(R.id.editar_tipo)
        val til_descripcion = findViewById<TextInputLayout>(R.id.editar_desc)

        var nombre_juego = til_nombre_juego.editText?.text.toString()
        var descripcion = til_descripcion.editText?.text.toString()


        val validador = Validador()
        var contador = 0
        //validacion spinner estado y tipo
        if (til_estado.getSelectedItem() == "Selecciona estado del Item"){
            (til_estado.getSelectedView() as TextView).error = getString(R.string.error_campo_requerido)
            contador ++
        }
        if (til_tipo.getSelectedItem() == "Selecciona Tipo de Item"){
            (til_tipo.getSelectedView() as TextView).error = getString(R.string.error_campo_requerido)
            contador ++
        }
        //validaciones nombre juego not null
        if(!validador.validarNull(nombre_juego) && validador.validarLargo(nombre_juego,3)){
            til_nombre_juego.error = getString(R.string.largo_nombre_juego)
            contador++
        }  else if (validador.validarNull(nombre_juego) && validador.validarLargo(nombre_juego,3)){
            til_nombre_juego.error = getString(R.string.error_campo_requerido)
            contador++
        } else if (!validador.validarNull(nombre_juego) && !validador.validarLargo(nombre_juego,3)){
            til_nombre_juego.error = ""
        }
        // validaciones descripción
        if(!validador.validarNull(descripcion) && validador.validarLargo(descripcion,15)){
            til_descripcion.error = getString(R.string.largo_descrip)
            contador++
        }  else if (validador.validarNull(descripcion) && validador.validarLargo(descripcion,15)){
            til_descripcion.error = getString(R.string.error_campo_requerido)
            contador++
        } else if (!validador.validarNull(descripcion) && !validador.validarLargo(descripcion,15)){
            til_descripcion.error = ""
        }
        return contador
    }
}