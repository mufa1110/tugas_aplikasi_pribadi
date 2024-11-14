package com.example.mufaproject.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mufaproject.R
import com.example.mufaproject.data.DataKonten

@Composable
fun ListScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 17.dp, end = 17.dp)
    ) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search", color = Color.Black.copy(alpha = 0.5f)) },
            shape = MaterialTheme.shapes.medium,
            trailingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Searching", tint = Color.Black.copy(alpha = 0.5f))
            },
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp).border(1.dp, Color(0xff00a9b8), shape = MaterialTheme.shapes.medium),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xffe8fdff),
                unfocusedContainerColor = Color(0xffe8fdff),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Box() {
            LazyVerticalGrid(
                modifier = Modifier.padding(bottom = 20.dp),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(DataKonten.semuaData1) { item ->
                    Card(
                        modifier = Modifier.width(100.dp).wrapContentHeight().clickable { navController.navigate("Detail/${item.id}") },
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xff00a9b8)
                        ),
                        shape = MaterialTheme.shapes.large
                    ) {
                        Box(
                            modifier = Modifier.padding(top = 19.dp, bottom = 25.dp).fillMaxWidth(),
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Card(
//                                modifier = Modifier.width(50.dp).wrapContentHeight()
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White
                                    ),
                                    shape = MaterialTheme.shapes.large
                                ) {
                                    Box(
                                        modifier = Modifier.padding(10.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = item.photo),
                                            contentDescription = item.judul,
                                            modifier = Modifier.size(66.dp),
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.padding(top = 13.dp))
                                Text(item.judul, color = Color.White, fontSize = 18.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}