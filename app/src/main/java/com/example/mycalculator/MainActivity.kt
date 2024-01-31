package com.example.mycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycalculator.ui.theme.Black
import com.example.mycalculator.ui.theme.DarkGray
import com.example.mycalculator.ui.theme.MyCalculatorTheme
import com.example.mycalculator.ui.theme.Red
import com.example.mycalculator.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing: Dp = 8.dp
                val onAction: (CalculatorAction) -> Unit = viewModel::onAction

                Box(
                    modifier = Modifier
                        .background(color = Black)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                    ) {
                        Text(
                            text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            fontWeight = FontWeight.Light,
                            fontSize = 80.sp,
                            color = White,
                            maxLines = 2
                        )
                        Box(
                            modifier = Modifier
                                .background(DarkGray)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Column {
                                    CalculatorButton(
                                        color = Red,
                                        symbol = "C",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Clear)
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "1",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(1))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "4",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(4))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "7",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(7))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "%",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Operation(CalculatorOperation.Percent))
                                        }
                                    )
                                }
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(buttonSpacing)
                                ) {
                                    CalculatorButton(
                                        color = Red,
                                        symbol = "/",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "2",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(2))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "5",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(5))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "8",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(8))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "0",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(0))
                                        }
                                    )
                                }
                                Column{
                                    CalculatorButton(
                                        color = Red,
                                        symbol = "*",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "3",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(3))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "6",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(6))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "9",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Number(9))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = ".",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Decimal)
                                        }
                                    )
                                }
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(buttonSpacing)
                                ) {
                                    CalculatorButton(
                                        color = Red,
                                        symbol = "<-",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Delete)
                                        }
                                    )
                                    CalculatorButton(
                                        color = Red,
                                        symbol = "-",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                                        }
                                    )
                                    CalculatorButton(
                                        color = Red,
                                        symbol = "+",
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                                        }
                                    )
                                    CalculatorButton(
                                        color = White,
                                        symbol = "=",
                                        modifier = Modifier
                                            .aspectRatio(1/2f)
                                            .weight(2f)
                                            .background(Red),
                                        onClick = {
                                            onAction(CalculatorAction.Calculate)
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}