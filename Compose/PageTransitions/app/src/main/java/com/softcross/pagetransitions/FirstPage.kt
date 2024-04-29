package com.softcross.pagetransitions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun FirstPage(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableIntStateOf(0)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "Hello this is first page!",
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Name:", modifier = Modifier.weight(15f))
            TextField(
                value = name,
                singleLine = true,
                label = { Text(text = "Name") },
                onValueChange = { name = it },
                modifier = Modifier
                    .weight(35f)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Age:", modifier = Modifier
                    .weight(15f)
                    .padding(start = 8.dp)
            )
            TextField(
                value = if (age == 0) "" else age.toString(),
                onValueChange = { age = it.toInt() },
                label = { Text(text = "Age") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(35f)
            )
        } // Take name and age from user
        Button(
            onClick = { navController.navigate("SecondPage" + "?name=${name}&age=${age}") } // pass taked name and age to second page.
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "ToSecondPage",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp)
            )
            Text(text = "Second Page")
        }
    }
}