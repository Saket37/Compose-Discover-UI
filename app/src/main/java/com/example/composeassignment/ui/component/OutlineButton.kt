package com.example.composeassignment.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeassignment.R

@Composable
fun OutlineButton(text: String,backgroundColor:Color,textColor: Color) {
    Button(
        modifier = Modifier
            .border(
                width = 2.dp, color = Color.Black, shape = RoundedCornerShape(size = 6.dp)
            )
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(size = 6.dp),
                color = backgroundColor,
            ),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        contentPadding = PaddingValues(vertical = 18.dp),
        onClick = { /*TODO*/ }) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(900),
                color = textColor,
                textAlign = TextAlign.Center,
                letterSpacing = 0.52.sp,
            )
        )
    }
}