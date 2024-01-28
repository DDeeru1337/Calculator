package com.example.mycalculator

sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    object Calculate: CalculatorAction()
    object Delete: CalculatorAction()
    object Clear: CalculatorAction()
    object Decimal: CalculatorAction()
    data class Operation(val operation: CalculatorOperation) : CalculatorAction()
}
