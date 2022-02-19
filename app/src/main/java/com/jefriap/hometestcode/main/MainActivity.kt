package com.jefriap.hometestcode.main

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.jefriap.hometestcode.main.bottomnavbar.*
import com.jefriap.hometestcode.main.ui.theme.HomeTestCodeFureeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeTestCodeFureeTheme {
                MainScreen()
            }
        }
    }
}

@Preview("MyScreen Preview", showBackground = true)
@Composable
fun DefaultPreview() {
    HomeTestCodeFureeTheme {

    }
}