package com.example.composeassignment.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.composeassignment.R

@Composable
fun Title(title: String, textSize: TextUnit, textColor: Color) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = textSize,
            fontFamily = FontFamily(Font(R.font.comfortaa_semibold)),
            fontWeight = FontWeight(400),
            color = textColor,
        )
    )
}

@Composable
fun Subtitle(title: String, textSize: TextUnit, textColor: Color) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = textSize,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontWeight = FontWeight(900),
            color = textColor,
            letterSpacing = 0.52.sp,
        )
    )
}