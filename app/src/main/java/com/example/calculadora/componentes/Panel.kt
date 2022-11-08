package com.example.calculadora.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val symbolList = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "x",
    "4", "5", "6", "-",
    "1", "2", "3", "+",
    "0", ".", "<-", "="
)


@Composable
fun Panel(
    modifier: Modifier = Modifier,
    height: Dp,
    width: Dp,
    onEvent: (CalculadoraEvent) -> Unit
) {
    Box{
        val size = (height / 5 )-10.dp  //El tamaño de la altura entre 5 menos la pantalla
        val widthButton = (width / 4) //En cada fila hay cuatro botones
        ()
    }
}