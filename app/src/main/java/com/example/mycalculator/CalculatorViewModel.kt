package com.example.mycalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation != null) {
            if (state.number2.length >= MAX_NUMBER_LENGTH) {
                return
            }
            state = state.copy(
                number2 = state.number2 + number
            )
            return
        }
        if (state.number1.length >= MAX_NUMBER_LENGTH) {
            return
        }
            state = state.copy(
                number1 = state.number1 + number
            )
    }
    companion object {
        private const val MAX_NUMBER_LENGTH = 8
    }

    private fun performDeletion() {
        if (state.number2.isNotBlank()) {
            state = state.copy(state.number2.dropLast(1))
            return
        }
        if (state.operation != null) {
            state = state.copy(operation = null)
            return
        }
        if (state.number1.isNotBlank()) {
            state = state.copy(state.number1.dropLast(1))
        }
    }

    private fun enterDecimal() {
        if (state.number2.isNotBlank() && !state.number2.contains(".")) {
            state = state.copy(number2 = state.number2 + ".")
            return
        }
        if (state.operation == null && state.number1.isNotBlank() && !state.number1.contains("."))
            state = state.copy(number1 = state.number1 + ".")
    }

    private fun performCalculation() {
        var number1 = state.number1.toDoubleOrNull()
        var number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Percent -> number1 % number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }
}