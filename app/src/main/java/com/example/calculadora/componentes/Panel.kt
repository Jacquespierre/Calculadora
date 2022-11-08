package com.example.calculadora.componentes

import android.graphics.Color
import android.view.Surface
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculadora.utiles.isNumero
import com.example.calculadora.utiles.sp
import java.time.format.TextStyle

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
    Box {
        val size = (height / 5) - 10.dp  //El tamaño de la altura entre 5 menos la pantalla
        val widthButton = (width / 4) - 6.75.dp //En cada fila hay cuatro botones

        LazyColumn(
            modifier = modifier.width(width)
        ) {
            items(
                items = symbolList.chunked(4)
            ) { rowItems ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    for (text in rowItems) {
                        ContentButton(
                            text =text ,
                            size =size,
                            width = width,
                            onEvent ={ onEvent(it)
                            }
                        )
                    }
                }
            }Spacer(
                    modifier = Modifier.height(10.dp))
        }
    }
}

private infix fun Unit.Spacer(unit: Unit) {

}

@Composable
fun ContentButton(
    text: String,
    size: Dp,
    width: Dp,
    onEvent: (CalculadoraEvent) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(width)
            .clickable {
                when (text) {
                    "C" -> onEvent(CalculadoraEvent.AllClear)
                    "<-" -> onEvent(CalculadoraEvent.Retroceder)
                    "=" -> onEvent(CalculadoraEvent.Igual)
                    else -> onEvent(CalculadoraEvent.Write(text))

                }
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(size)
                .background(if (isNumero(text)) Color(0xFFEDE7F6) else Color(0xFFFF8A65))

        ) {
            Text(
                text = text,
                color = if (isNumero(text)) Color(0xFF616161) else Color(0xFFFFFFFF),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = size.sp()
                )
            )
        }
    }

}