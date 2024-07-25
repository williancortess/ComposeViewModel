package br.com.will.jetpackviewmodel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Indigo400,
    primaryVariant = Indigo400Light,
    secondary = Indigo500,
    onSecondary = Color.White
)

private val LightColorPalette = lightColors(
    primary = Indigo400,
    primaryVariant = Indigo400Light,
    secondary = Indigo500,
    onSecondary = Color.White
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}