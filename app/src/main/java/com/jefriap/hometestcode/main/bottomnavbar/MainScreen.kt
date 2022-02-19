package com.jefriap.hometestcode.main.bottomnavbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navController)
        }
    ) {
        BottomNavGraph(navHostController = navController)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomBar(navHostController: NavHostController) {
    val screen = listOf(
        BottomNavigationBar.Home,
        BottomNavigationBar.Favorite,
        BottomNavigationBar.Notification,
        BottomNavigationBar.Profile
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        modifier= Modifier.height(60.dp)
    ) {
        Row(
            modifier= Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            screen.forEach { screen ->
                AddItem(screen = screen, currentDestination = currentDestination, navHostController = navHostController)
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun RowScope.AddItem(
    screen: BottomNavigationBar,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    BottomNavigationItem(
        icon = {
            val isSelected = screen.route == currentDestination?.route

            val background =
                if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
            val contentColor =
                if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(background)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp, 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = "Navigation Icon",
                        tint = contentColor
                    )
                }
            }
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}


@Composable
@Preview
fun Prev1(){
    val navController = rememberNavController()

    BottomBar(navHostController = navController)
}