package com.example.composeassignment.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CircularImage(
    image: Int, modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(60.dp)
            .clip(CircleShape),
        painter = painterResource(id = image),
        contentDescription = null, alignment = Alignment.Center, contentScale = ContentScale.Crop
    )
}