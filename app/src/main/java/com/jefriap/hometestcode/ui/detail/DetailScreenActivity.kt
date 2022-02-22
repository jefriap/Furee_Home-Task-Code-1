package com.jefriap.hometestcode.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jefriap.hometestcode.data.ClothesData
import com.jefriap.hometestcode.ui.theme.HomeTestCodeFureeTheme

class DetailScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeTestCodeFureeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val data = intent.getParcelableExtra<ClothesData>(EXTRA_DATA) as ClothesData
                    DetailScreen(data = data)
                }
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    HomeTestCodeFureeTheme {
        Greeting("Android")
    }
}