package com.softcross.firstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softcross.firstproject.ui.theme.FirstProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { // This block for the emulator.
                    Greeting()
                }
            }
        }
    }
}

@Composable // This keyword represent this code for the UI.
fun Greeting() {
    val number = remember {
        mutableIntStateOf(0)
    }
    // Or can use as number by remember{}...
    // On this usage you can access number instead of number.value
    var name by remember {
        mutableStateOf("")
    }

    // Selection container for can select labels.
    SelectionContainer {
        // Column, we can think this like horizontal linear layout on XML
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            // This, disable selectable for own scope items
            DisableSelection {
                Text(
                    text = "Hello Android!",
                    fontStyle = FontStyle.Italic,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 5.sp,
                    color = Color.Blue,
                )
            }
            // Row, we can think this like vertical linear layout on XML
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hello Eren!",
                    fontStyle = FontStyle.Normal,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Default,
                    letterSpacing = 3.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(20f)
                )
                Text(
                    text = "This is your first compose project!",
                    fontStyle = FontStyle.Italic,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    letterSpacing = 2.sp,
                    modifier = Modifier
                        .weight(60f)
                        // Weight divide by percentage all views
                        // This mean is this Column size is 10% of all page
                        .padding(horizontal = 12.dp)
                )
                Text(
                    text = "Good Luck!",
                    fontStyle = FontStyle.Normal,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Default,
                    letterSpacing = 3.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(20f)
                )
            }
            Text(
                text = "Hello Compose!",
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                letterSpacing = 1.sp,
                color = Color.Red,
            )
            MyView() // Custom composable function
            Box (contentAlignment = Alignment.Center){// This puts items on scope on top of each other
                Box(modifier = Modifier.size(32.dp).background(Color.Blue))
                Box(modifier = Modifier.size(16.dp).background(Color.Yellow))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = number.intValue.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Add",
                    modifier = Modifier
                        .clickable {
                            number.intValue++
                        }
                        .padding(bottom = 8.dp),
                    textAlign = TextAlign.Center
                )
                Button(
                    onClick = { number.intValue-- },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White

                    ),
                ) {
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Odd", modifier = Modifier
                                .padding(end = 8.dp)
                        )
                        Box(
                            modifier = Modifier
                                .height(3.dp)
                                .width(12.dp)
                                .background(Color.White)
                                .padding(start = 8.dp)
                        )
                    }
                }
                // Also you can use these buttons;
                // Outlined Button, Text Button etc.
                // If you want you can check Material3 for more detail.

            }
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Name:",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(end = 8.dp)
                )
                // Text field for user input
                TextField(
                    value = name,
                    onValueChange = { // When change value do what is inside of input
                        if (it.length <= 5) {
                            name = it
                        }
                    },
                    supportingText = { // Items on bottom of the text field
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(
                                Icons.Filled.Done,
                                contentDescription = "Accepted Length",
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "${name.length}/5"
                            )
                        }
                    },
                    leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Name") }, // Icon
                    label = { Text(text = "Enter Name") }, // Hint Items
                    singleLine = true, // Set single line content
                    modifier = Modifier
                        .weight(40f)
                        .padding(start = 8.dp, end = 8.dp, top = 24.dp)

                )
                Text(
                    text = "Name is $name",
                    modifier = Modifier.weight(35f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() { // This fun for the preview mode.
    FirstProjectTheme {
        Greeting()
    }
}