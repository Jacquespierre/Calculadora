package com.example.calculadora.utiles

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

//CONVERSION DE .Dp a .sp
@Composable
fun Dp.sp() = with(LocalDensity.current){
    toSp()
}