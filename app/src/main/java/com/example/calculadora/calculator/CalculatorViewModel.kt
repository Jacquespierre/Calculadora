package com.example.calculadora.calculator

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    private val _inputText = mutableStateOf(CalculatorState())
    var inputText: State<CalculatorState> = _inputText

    private val _outputText = mutableStateOf(CalculatorState())
    var outputText: State<CalculatorState> = _outputText
}