package com.example.calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.calculadora.componentes.MainContent
import com.example.calculadora.componentes.Panel

@Composable
fun CalculadoraApp(
    viewModel: calculatorViewModel
) {
    val inputState = viewModel.inputText.value
    val outputState = viewModel.outputText.value

    CaluladoraTema
    {
        CalculadoraPantalla(
            inputText: inputState. text,
        outputText = outputState.text,
        onEvent = {
            viewModel.onEvent(it)
        }
        )
    }
}

@Composable
fun CalculadoraPantalla(
    inputText: String,
    outputText: String,
    onEvent: (CalculadoraEvent) -> Unit
) {
    BoxWithConstraints() {//Calcula el máximo de altura y anchura del dispositivo para encajar el panel y el nameContent
        val boxHeight = this.maxHeight
        val boxWidth = this.maxWidth

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            MainContent(
                inputText = inputText,
                outputText = outputText,
                height = boxHeight * 0.4f //Ocupa el 40 %


            )
            Panel(
                height = boxHeight,
                width = boxWidth,
                onEvent = onEvent
            )
        }

    }
}