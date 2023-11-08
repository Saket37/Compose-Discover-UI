package com.example.composeassignment.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeassignment.R
import com.example.composeassignment.ui.component.CircularImage
import com.example.composeassignment.ui.component.OutlineButton
import com.example.composeassignment.ui.component.Subtitle
import com.example.composeassignment.ui.component.Title
import com.example.composeassignment.ui.component.gridItems
import com.example.composeassignment.ui.discover.BrowseImage

val profileImages = listOf(
    R.drawable.p_1,
    R.drawable.p_2,
    R.drawable.p_3,
    R.drawable.b_4,
    R.drawable.b_5,
    R.drawable.b_6,
    R.drawable.b_7,
    R.drawable.b_8
)

@Composable
fun ProfileScreen() {
    LazyColumn(
        modifier = Modifier.padding(
            horizontal = 16.dp
        ),
        verticalArrangement = Arrangement.Top,
    ) {
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                CircularImage(image = R.drawable.profile, modifier = Modifier.size(128.dp))
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Title(title = "Jane", textSize = 36.sp, textColor = Color.Black)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Subtitle(title = "SAN FRANCISCO, CA", textSize = 13.sp, textColor = Color.Black)
            }
            Spacer(modifier = Modifier.height(32.dp))
            OutlineButton(
                text = "FOLLOW JANE",
                backgroundColor = Color.Black,
                textColor = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlineButton(text = "MESSAGE", backgroundColor = Color.White, textColor = Color.Black)
            Spacer(modifier = Modifier.height(32.dp))

        }
        gridItems(
            profileImages,
            columnCount = 2,
            horizontalArrangement = Arrangement.spacedBy(9.dp),
            modifier = Modifier
        ) {
            BrowseImage(image = it)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}