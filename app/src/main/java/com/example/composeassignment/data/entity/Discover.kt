package com.example.composeassignment.data.entity

import androidx.annotation.DrawableRes

data class Discover(
    val userName: String,
    val userHandle: String,
    @DrawableRes val userImage: Int,
    @DrawableRes val image: Int
)
