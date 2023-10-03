package com.example.switchin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


class RegistrarUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)

        val btn_registrarse = findViewById<Button>(R.id.btn_registrarse)

        btn_registrarse.setOnClickListener{
            if ( validacionCampos() == 0){
                val intent = Intent(this@RegistrarUsuarioActivity, ListadoColeccionActivity::class.java )
                Toast.makeText( this,"Usuario registrado con éxito", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

    }
    fun validacionCampos(): Int{
        val tipo_coleccion = findViewById<Spinner>(R.id.tipo_coleccion)
        val til_usuario = findViewById<TextInputLayout>(R.id.ingreso_usuario)
        val til_correo = findViewById<TextInputLayout>(R.id.ingreso_correo)
        val til_clave = findViewById<TextInputLayout>(R.id.ingreso_clave)
        val til_conf_clave = findViewById<TextInputLayout>(R.id.confirmar_clave)

        var seleccion_tipo = tipo_coleccion.getSelectedItem().toString();
        var nombre_usuario = til_usuario.editText?.text.toString()
        var correo = til_correo.editText?.text.toString()
        var clave = til_clave.editText?.text.toString()
        var conf_clave = til_conf_clave.editText?.text.toString()

        val validador = Validador()
        var contador = 0
        //validacion spinner
        if (tipo_coleccion.getSelectedItem() == "Seleccione Tipo de colección"){
            (tipo_coleccion.getSelectedView() as TextView).error = getString(R.string.error_campo_requerido)
            contador ++
        }
        //validaciones nombre
        if(!validador.validarNull(nombre_usuario) && validador.validarNombreUsu(nombre_usuario)){
            til_usuario.error = getString(R.string.usu_nok)
            contador++
        }  else if (validador.validarNull(nombre_usuario) && validador.validarNombreUsu(nombre_usuario)){
            til_usuario.error = getString(R.string.error_campo_requerido)
            contador++
        } else if (!validador.validarNull(nombre_usuario) && !validador.validarNombreUsu(nombre_usuario)){
            til_usuario.error = ""
        }
        //validaciones correo
        if(!validador.validarNull(correo) && validador.validarFormatoCorreo(correo)){
            til_correo.error = getString(R.string.formato_correo)
            contador++
        }  else if (validador.validarNull(correo) && validador.validarFormatoCorreo(nombre_usuario)){
            til_correo.error = getString(R.string.error_campo_requerido)
            contador++
        } else if (!validador.validarNull(correo) && !validador.validarFormatoCorreo(correo)){
            til_correo.error = ""
        }

        // validacion clave
        if (!validador.validarNull(clave) && validador.validarLargoClave(clave)){
            til_clave.error = getString(R.string.largo_clave)
            contador++
        } else if (validador.validarNull(clave) && validador.validarLargoClave(clave)) {
            til_clave.error = getString(R.string.error_campo_requerido)
            contador++
        }
        //validación conf clave
        if (!validador.validarNull(conf_clave) && validador.validarLargoClave(conf_clave)){
            til_conf_clave.error =getString(R.string.largo_clave)
            contador++
        } else if (validador.validarNull(conf_clave) && validador.validarLargoClave(conf_clave)) {
            til_conf_clave.error = getString(R.string.error_campo_requerido)
            contador++
        }
        if(validador.validarCamposIguales(clave, conf_clave) && !validador.validarNull(clave) && !validador.validarLargoClave(clave)){
            til_clave.error = getString(R.string.clave_igual)
            til_conf_clave.error = getString(R.string.clave_igual)
            contador++
        } else if (!validador.validarCamposIguales(clave, conf_clave) && !validador.validarNull(clave) && !validador.validarLargoClave(clave)) {
            til_clave.error = ""
            til_conf_clave.error = ""
        }
        println(contador)
        return contador
    }
}