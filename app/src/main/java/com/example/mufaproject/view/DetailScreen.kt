package com.example.mufaproject.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mufaproject.data.DataKonten

@Composable
fun DetailScreen(dataID: Int) {
    val data = DataKonten.semuaData1.find { it.id == dataID }
    if (data != null) {
        Column(
            modifier = Modifier
                .padding(start = 17.dp, end = 17.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Image(
                        painter = painterResource(id = data.photo),
                        contentDescription = data.judul,
                        modifier = Modifier
                            .size(90.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 13.dp)
                    ) {
                        Text(
                            text = data.judul,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            text = data.jenis,
                            fontSize = 15.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Box {
                Column {
                    Text(
                        text = "Apa itu ${data.judul}?",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 17.sp,
                        color = Color.Black.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.padding(top = 9.dp))
                    LazyColumn {
                        item {
                            Text(
                                text = data.desc,
                                fontSize = 13.sp,
                                color = Color.Black.copy(alpha = 0.5f)
                            )
                        }
                    }
                }
            }
        }
    }
}