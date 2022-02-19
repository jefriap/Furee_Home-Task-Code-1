package com.jefriap.hometestcode.main.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jefriap.hometestcode.R

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 20.dp, 15.dp, 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                modifier = Modifier.alpha(ContentAlpha.medium),
                onClick = { Log.d("top_app_bar", "Ini btn menu") }
            ) {
               Icon(
                   imageVector = Icons.Outlined.Menu,
                   contentDescription = "Menu Icon Button")
            }
            IconButton(
                modifier = Modifier.alpha(ContentAlpha.medium),
                onClick = { Log.d("top_app_bar", "Ini btn shop") }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.shopping_bag_outline),
                    contentDescription = "Shopping bag Icon Button")
            }
        }

        Card(
            modifier = Modifier.padding(15.dp)
        ) {

        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}