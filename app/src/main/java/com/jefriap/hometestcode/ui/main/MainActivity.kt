package com.jefriap.hometestcode.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jefriap.hometestcode.ui.main.bottomnavbar.MainScreen
import com.jefriap.hometestcode.ui.theme.HomeTestCodeFureeTheme

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