package com.example.mycalculator

data class CalculatorState (
    val number1: String = "",
    val number2: String = "",
    val calculatorOperation: CalculatorOperation? = null
)