package com.softcross.firstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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
    SelectionContainer {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            DisableSelection {
                Text(
                    text = "Hello Android!",
                    fontStyle = FontStyle.Italic,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 5.sp,
                    color = Color.Blue
                )
            }
            Text(
                text = "Hello Eren!",
                fontStyle = FontStyle.Normal,
                fontSize = 30.sp,
                fontFamily = FontFamily.Default,
                letterSpacing = 3.sp,
                color = Color.Black
            )
            Text(
                text = "Hello Compose!",
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                letterSpacing = 1.sp,
                color = Color.Red
            )
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