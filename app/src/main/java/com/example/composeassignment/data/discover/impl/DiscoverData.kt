package com.example.composeassignment.data.discover.impl

import com.example.composeassignment.R
import com.example.composeassignment.data.entity.Discover

val discoverItem1 = Discover(
    userName = "Ridhwan Nordin",
    userHandle = "@ridzjcob",
    userImage = R.drawable.u_1,
    image = R.drawable.d_1
)

val discoverItem2 = Discover(
    userName = "Clem Onojeghuo",
    userHandle = "@clemono2",
    userImage = R.drawable.u_2,
    image = R.drawable.d_2
)
val discoverItem3 = Discover(
    userName = "Jon Tyson",
    userHandle = "@jontyson",
    userImage = R.drawable.u_3,
    image = R.drawable.d_3
)
val discoverItem4 = Discover(
    userName = "Simon Zhu",
    userHandle = "@smnzhu",
    userImage = R.drawable.u_4,
    image = R.drawable.d_4
)

val discoverItems = listOf(discoverItem1, discoverItem2, discoverItem3, discoverItem4)