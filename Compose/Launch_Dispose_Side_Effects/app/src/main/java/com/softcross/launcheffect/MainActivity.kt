package com.softcross.launcheffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.softcross.launcheffect.ui.theme.LaunchEffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchEffectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageTransitions()
                }
            }
        }
    }
}

@Composable
fun SecondPage(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Second Page")
        Button(onClick = { navController.navigate("Greeting") }) { Text(text = "Page 1") }
    }
}

@Composable
fun PageTransitions() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Greeting") {

        composable("SecondPage") { SecondPage(navController) }
        composable("Greeting") { Greeting(navController) }

    }
}

@Composable
fun Greeting(navController: NavController) {


    var name by remember {
        mutableStateOf("")
    }

    var count by remember {
        mutableIntStateOf(0)
    }

    // Launch effect execute when variable "name" changed and first run of the app.
    LaunchedEffect(key1 = name) {
        count++
    }

    // Disposable effect execute when variable "name" changed and transition to other page.
    DisposableEffect(key1 = name) {
        println("Effect")
        onDispose {
            println("onDispose()")
        }
    }

    // Side effect execute when any item state changed and first launch.
    SideEffect {

    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = count.toString())
        TextField(value = name, onValueChange = { name = it })
        Button(onClick = { navController.navigate("SecondPage") }) { Text(text = "Page 2") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaunchEffectTheme {
        PageTransitions()
    }
}