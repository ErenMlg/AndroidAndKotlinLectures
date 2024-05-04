package com.softcross.fab_iconbutton_switch_checkbox_radiobutton

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.softcross.fab_iconbutton_switch_checkbox_radiobutton.ui.theme.Fab_IconButton_Switch_CheckBox_RadioButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Fab_IconButton_Switch_CheckBox_RadioButtonTheme {
                Scaffold(
                    floatingActionButton = {
                        val context = LocalContext.current
                        /* Normal FAB
                        FloatingActionButton(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "FAB Clicked",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            containerColor = Color.Cyan,
                            contentColor = Color.Blue
                        ) {
                            Icon(Icons.Filled.Create, contentDescription = "")
                        }*/
                        ExtendedFloatingActionButton(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "FAB Clicked",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            containerColor = Color.Cyan,
                            contentColor = Color.Blue
                        ) {
                            Text(text = "Extended FAB")
                            Icon(Icons.Filled.Create, contentDescription = "")
                        }
                    }
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val context = LocalContext.current
    var checkedSwitch by remember {
        mutableStateOf(true)
    }
    var checkedBox by remember {
        mutableStateOf(true)
    }

    val myList = listOf("Kotlin", "Compose", "XML")
    var myIndex by remember {
        mutableIntStateOf(0)
    }
    var mySelection by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = {
            Toast.makeText(context, "Icon Button Clicked", Toast.LENGTH_LONG).show()
        }) {
            Icon(Icons.Filled.Add, contentDescription = "")
        }

        OutlinedIconButton(onClick = {
            Toast.makeText(context, "Outlined Icon Button Clicked", Toast.LENGTH_LONG).show()
        }) {
            Icon(Icons.Filled.Add, contentDescription = "")
        }
        Switch(
            checked = checkedSwitch, onCheckedChange = {
                checkedSwitch = it
                Toast.makeText(context, "Switch : $it", Toast.LENGTH_LONG).show()
            },
            thumbContent = {
                Icon(
                    if (checkedSwitch) Icons.Filled.Check else Icons.Filled.Clear,
                    contentDescription = "",
                    Modifier.size(SwitchDefaults.IconSize)
                )
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                checkedTrackColor = Color.Magenta,
                uncheckedThumbColor = Color.DarkGray,
                uncheckedTrackColor = Color.Yellow
            )
        )
        Checkbox(
            checked = checkedBox, onCheckedChange = {
                checkedBox = it
                Toast.makeText(context, "CheckBox : $it", Toast.LENGTH_LONG).show()
            },
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.Cyan,
                checkedColor = Color.Yellow,
                uncheckedColor = Color.Blue
            )
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = mySelection)
            myList.forEachIndexed { index, s ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = s == myList[myIndex], onClick = {
                        myIndex = index
                        mySelection = s
                    })
                    Text(text = s)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Fab_IconButton_Switch_CheckBox_RadioButtonTheme {
        Greeting()
    }
}