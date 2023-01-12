package com.example.meditationui
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import java.util.*

fun Path.standardQuadto(from: Offset, to : Offset)
{
    quadraticBezierTo(
        from.x,
        from.y,
        (from.x+to.x)/2,
            (from.y+to.y)/2

    )
}
