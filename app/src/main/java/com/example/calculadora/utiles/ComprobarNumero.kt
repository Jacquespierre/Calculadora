package com.example.calculadora.utiles

fun isNumero(s: String): Boolean {
    return if(s.isEmpty()) false else s.all{ Character.isDigit(it) }||s == "."
}