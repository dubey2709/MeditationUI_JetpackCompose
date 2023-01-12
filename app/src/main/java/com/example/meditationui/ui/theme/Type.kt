package com.plcoding.meditationuiyoutube.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.meditationui.ui.theme.AquaBlue
import com.example.meditationui.ui.theme.TextWhite


val Typography = Typography(
    body1 = TextStyle(
        color = AquaBlue,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        color = TextWhite,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        color = TextWhite,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)