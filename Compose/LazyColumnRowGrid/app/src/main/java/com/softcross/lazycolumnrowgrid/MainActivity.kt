package com.softcross.lazycolumnrowgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softcross.lazycolumnrowgrid.ui.theme.LazyColumnRowGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyColumnRowGridTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

data class data(val number: Int, val icon: ImageVector, val name: String)

@Composable
fun Greeting() {
    val list = listOf(
        data(1, Icons.Filled.Face, "Eren"),
        data(2, Icons.Filled.List, "Deliha"),
        data(3, Icons.Filled.AddCircle, "Ayşe"),
        data(4, Icons.Filled.AccountBox, "Mehmet"),
        data(5, Icons.Filled.Face, "Eren"),
        data(6, Icons.Filled.List, "Deliha"),
        data(7, Icons.Filled.AddCircle, "Ayşe"),
        data(8, Icons.Filled.AccountBox, "Mehmet"),
        data(9, Icons.Filled.Face, "Eren"),
        data(10, Icons.Filled.List, "Deliha"),
        data(11, Icons.Filled.AddCircle, "Ayşe"),
        data(12, Icons.Filled.AccountBox, "Mehmet"),
        data(13, Icons.Filled.Face, "Eren"),
        data(14, Icons.Filled.List, "Deliha"),
        data(15, Icons.Filled.AddCircle, "Ayşe"),
        data(16, Icons.Filled.AccountBox, "Mehmet")
    )

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LazyVerticalGridView(list = list)
        LazyHorizontalGridView(list = list)
        LazyRowView(list = list)
        LazyColumnView(list = list)
    }
}

@Composable
private fun LazyVerticalGridView(list: List<data>) {
    LazyVerticalGrid(
        modifier = Modifier.height(250.dp),
        columns = GridCells.Fixed(2) // One column 2 item
        // columns = GridCells.FixedSize(128.dp) // All cells size is 128dp
        // columns = GridCells.Adaptive(128.dp) // Minimum cell size is 128dp it can may bigger than 128dp
    ) {
        items(list) {
            Card(
                modifier = Modifier.padding(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Green
                )
            ) {
                Column(
                    Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        it.icon,
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 15.dp, bottom = 5.dp)
                    )
                    Text(
                        text = it.name,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                    Text(
                        text = it.number.toString(),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 5.dp, bottom = 15.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun LazyHorizontalGridView(list: List<data>) {
    LazyHorizontalGrid(
        modifier = Modifier.height(250.dp),
        rows = GridCells.Fixed(2) // One row 2 item
        // rows = GridCells.FixedSize(128.dp) // All cells size is 128dp
        // rows = GridCells.Adaptive(128.dp) // Minimum cell size is 128dp it can may bigger than 128dp
    ) {
        items(list) {
            Card(
                modifier = Modifier.padding(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Blue
                )
            ) {
                Column(
                    Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        it.icon,
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 15.dp, bottom = 5.dp)
                    )
                    Text(
                        text = it.name,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                    Text(
                        text = it.number.toString(),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 5.dp, bottom = 15.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun LazyRowView(list: List<data>) {
    // We can say LazyRow is vertical recycler view
    LazyRow(
        modifier = Modifier.height(250.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        items(list) {
            Card(
                modifier = Modifier.padding(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        it.icon,
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 15.dp, bottom = 5.dp)
                    )
                    Text(
                        text = it.name,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                    Text(
                        text = it.number.toString(),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 5.dp, bottom = 15.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun LazyColumnView(list: List<data>) {
    // We can say LazyColumn is horizontal recycler view
    LazyColumn(
        modifier = Modifier.height(250.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(list) {
            Card(
                modifier = Modifier.padding(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Cyan
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        it.icon,
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 15.dp, bottom = 5.dp)
                    )
                    Text(
                        text = it.name,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                    Text(
                        text = it.number.toString(),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 5.dp, bottom = 15.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyColumnRowGridTheme {
        Greeting()
    }
}