package com.softcross.pagetransitions

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SecondPage(navController: NavController, name: String, age: Int) {

    BackHandler( // Back press handler
        onBack = {
            println("Pressed back button")
        }
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "Hello $name",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "You are $age years old",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
        Button(
            onClick = {
                navController.navigate("ThirdPage") {
                    popUpTo("SecondPage") {// Pop up second page to stack
                        inclusive = true
                    }
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "ToThirdPage",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp)
            )
            Text(text = "Third Page")
        }
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "ToFirstPage",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp)
            )
            Text(text = "First Page")
        }
    }
}