package com.example.composeassignment.ui.component

import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.composeassignment.navigation.Routes

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    currentDestination: Routes,
    onNavigate: (routes: Routes) -> Unit
) {
    NavigationBar(modifier = modifier) {
        listOf(Routes.Discover, Routes.Search, Routes.Create, Routes.Chat, Routes.Profile).forEach {
            val selectedTab = currentDestination.path == it.path
            NavigationBarItem(
                selected = selectedTab,
                onClick = { onNavigate(it) },
                icon = {
                    it.icon?.let { img ->
                        Image(painter = painterResource(id = img), contentDescription = it.path)
                    }
                })
        }
    }
}
