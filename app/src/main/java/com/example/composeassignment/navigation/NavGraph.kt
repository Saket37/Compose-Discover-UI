package com.example.composeassignment.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.composeassignment.ui.ProfileScreen
import com.example.composeassignment.ui.discover.DiscoverScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = Routes.Home.path
) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        navigation(startDestination = Routes.Discover.path, route = Routes.Home.path) {
            composable(route = Routes.Discover.path) {
                Box(modifier = Modifier.fillMaxSize()) {
                    DiscoverScreen()
                }
            }
            composable(route = Routes.Search.path) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Search")
                }
            }
            composable(route = Routes.Create.path) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Create")
                }
            }
            composable(route = Routes.Chat.path) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Chat")
                }
            }
            composable(route = Routes.Profile.path) {
                Box(modifier = Modifier.fillMaxSize()) {
                    ProfileScreen()
                }
            }
        }
    }
}