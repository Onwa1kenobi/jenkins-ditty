package io.ugochukwu.demoapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.ugochukwu.demoapplication.R

private val Nunito = FontFamily(
    Font(R.font.nunito_regular),
    Font(R.font.nunito_semibold, FontWeight.W500),
    Font(R.font.nunito_bold, FontWeight.W600),
)

// Set of Material typography styles to start with
fun typography(isDarkTheme: Boolean) = Typography(
    /* Other default text styles to override
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */

    /*      h1	displayLarge
            h2	displayMedium
            h3	displaySmall
            N/A	headlineLarge
            h4	headlineMedium
            h5	headlineSmall
            h6	titleLarge
            subtitle1	titleMedium
            subtitle2	titleSmall
            body1	bodyLarge
            body2	bodyMedium
            caption	bodySmall
            button	labelLarge
            N/A	labelMedium
            overline	labelSmall  */

    headlineMedium = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        color = if (isDarkTheme) White else DarkText
    ),
    titleMedium = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        color = if (isDarkTheme) White else DarkText
    ),
    titleSmall = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        color = if (isDarkTheme) White else DarkText
    ),
    bodyLarge = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = if (isDarkTheme) White else DarkText
    ),
    bodyMedium = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        color = if (isDarkTheme) DarkText else White
    ),
    bodySmall = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)