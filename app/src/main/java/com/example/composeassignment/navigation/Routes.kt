package com.example.composeassignment.navigation

import com.example.composeassignment.R

sealed class Routes(
    val path: String,
    val icon: Int? = null
) {
    companion object {
        fun fromString(route: String): Routes {
            return when (route) {
                Discover.path -> Discover
                Search.path -> Search
                Create.path -> Create
                Chat.path -> Chat
                Profile.path -> Profile
                else -> Home
            }
        }
    }

    object Home : Routes("HOME")
    object Discover : Routes("DISCOVER", icon = R.drawable.ic_home)
    object Search : Routes("SEARCH", icon = R.drawable.ic_search)
    object Create : Routes("CREATE", icon = R.drawable.ic_create)
    object Chat : Routes("CHAT", R.drawable.ic_chat)
    object Profile : Routes("PROFILE", icon = R.drawable.ic_profile)
}


