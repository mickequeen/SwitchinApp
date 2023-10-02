package com.example.switchin

import android.util.Patterns
import java.util.regex.Pattern

class Validador {
    fun validarNull(texto: String): Boolean {
        return texto.trim().equals("") || texto.trim().length == 0

    }
    fun validarCamposIguales(texto: String, texto2: String): Boolean {
        return !texto.trim().equals(texto2.trim())
    }
    fun validarNombreUsu(nombre: String): Boolean {
        val pattern = Pattern.compile(/* regex = */ "^[A-Za-z][A-Za-z0-9_]{2,19}$")
        return !pattern.matcher(nombre).matches()
    }
    fun validarFormatoCorreo(correo: String): Boolean {
        return !Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    }

    fun validarLargoClave(clave: String): Boolean {
        return clave.length < 5
    }
}