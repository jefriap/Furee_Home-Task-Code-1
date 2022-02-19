package com.jefriap.hometestcode.main.bottomnavbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jefriap.hometestcode.main.favorite.FavoriteScreen
import com.jefriap.hometestcode.main.home.HomeScreen
import com.jefriap.hometestcode.main.notification.NotificationScreen
import com.jefriap.hometestcode.main.profile.ProfileScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavigationBar.Home.route
    ) {
        composable(
            route = BottomNavigationBar.Home.route
        ) {
            HomeScreen()
        }
        composable(
            route = BottomNavigationBar.Favorite.route
        ) {
            FavoriteScreen()
        }
        composable(
            route = BottomNavigationBar.Notification.route
        ) {
            NotificationScreen()
        }
        composable(
            route = BottomNavigationBar.Profile.route
        ) {
            ProfileScreen()
        }
    }
}