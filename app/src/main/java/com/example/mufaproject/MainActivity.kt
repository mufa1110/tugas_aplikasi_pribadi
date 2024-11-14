package com.example.mufaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mufaproject.ui.theme.MufaProjectTheme
import com.example.mufaproject.view.AboutScreen
import com.example.mufaproject.view.BerandaUtama
import com.example.mufaproject.view.DetailScreen
import com.example.mufaproject.view.HeaderTopBar
import com.example.mufaproject.view.ListScreen
import com.example.mufaproject.view.NavbarBottom

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MufaProjectTheme {
                ScreenUtama()
            }
        }
    }
}

@Composable
fun ScreenUtama() {
    val navController = rememberNavController()
    var title by remember { mutableStateOf("Beranda") }
    var back = "False"

    Scaffold (
        bottomBar = { NavbarBottom(navController) }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = Color.White
//            color = Color(0xFFedfeff)
        ) {
            Column {
                HeaderTopBar(navController = navController, titleHeaderNya = title, back = back)
                NavHost(navController, startDestination = "Beranda") {
                    composable("Beranda") {
                        back = "False"
                        title = "Beranda"
                        BerandaUtama(navController)
                    }
                    composable("List") {
                        back = "False"
                        title = "List"
                        ListScreen(navController)
                    }
                    composable("About") {
                        back = "False"
                        title = "About"
                        AboutScreen(navController)
                    }
                    composable("Detail/{dataID}", arguments = listOf(navArgument("dataID") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val dataID = backStackEntry.arguments?.getInt("dataID") ?: -1
                        DetailScreen(dataID)
                        back = "True"
                        title = "Detail"
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreennya() {
    MufaProjectTheme {
        ScreenUtama()
    }
}