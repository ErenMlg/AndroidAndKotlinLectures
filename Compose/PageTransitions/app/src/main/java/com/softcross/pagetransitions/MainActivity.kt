package com.softcross.pagetransitions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.softcross.pagetransitions.ui.theme.PageTransitionsTheme
import com.softcross.pagetransitions.ui.theme.ThirdPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PageTransitionsTheme {
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
fun PageTransitions() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "FirstPage") {
        composable("FirstPage") { FirstPage(navController) }
        composable(
            "SecondPage" + "?name={name}&age={age}", // Define data names.
            arguments = listOf(
                navArgument(name = "name") {// Define data' type
                    type = NavType.StringType
                    defaultValue = "Non Name"
                },
                navArgument(name = "age") {// Define data' type
                    type = NavType.IntType
                    defaultValue = 0
                }
            ) // Data transition between pages
        ) {
            val name = it.arguments?.getString("name")!! // Get datas from arguments
            val age = it.arguments?.getInt("age")!!
            SecondPage(navController, name, age) // Pass data to second page
        }
        composable("ThirdPage") { ThirdPage(navController) }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PageTransitionsTheme {
        PageTransitions()
    }
}