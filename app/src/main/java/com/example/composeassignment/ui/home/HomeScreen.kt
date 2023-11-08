package com.example.composeassignment.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeassignment.navigation.Navigation
import com.example.composeassignment.navigation.Routes
import com.example.composeassignment.ui.component.BottomNavBar

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry.value?.destination?.route?.let {
                Routes.fromString(it)
            } ?: run { Routes.Home }
        }
    }
    Scaffold(bottomBar = {
        BottomNavBar(currentDestination = currentDestination, onNavigate = {
            navController.navigate(it.path) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        })
    }) { innerPadding ->
        Box(
            modifier = Modifier.padding(
                0.dp,
                innerPadding.calculateTopPadding(),
                0.dp,
                innerPadding.calculateBottomPadding()
            )
        ) {
            Column {
                Navigation(modifier = Modifier, navHostController = navController)
            }
        }

    }
}