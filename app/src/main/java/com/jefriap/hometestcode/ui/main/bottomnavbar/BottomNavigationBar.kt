package com.jefriap.hometestcode.ui.main.bottomnavbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationBar(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomNavigationBar(
        route =  "home",
        title = "Home",
        icon = Icons.Outlined.Home
    )
    object Favorite: BottomNavigationBar(
        route =  "favorite",
        title = "Favorite",
        icon = Icons.Outlined.FavoriteBorder
    )
    object Notification: BottomNavigationBar(
        route =  "notification",
        title = "Notification",
        icon = Icons.Outlined.Notifications
    )
    object Profile: BottomNavigationBar(
        route =  "profile",
        title = "Profile",
        icon = Icons.Outlined.Person
    )
}
