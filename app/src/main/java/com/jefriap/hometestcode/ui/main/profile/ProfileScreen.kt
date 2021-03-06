package com.jefriap.hometestcode.ui.main.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Profile Screen",
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    ProfileScreen()
}