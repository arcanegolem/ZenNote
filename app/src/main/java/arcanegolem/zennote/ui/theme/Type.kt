package arcanegolem.zennote.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import arcanegolem.zennote.R

val SanFrancisco = FontFamily(
   Font(R.font.sfpro_black),
   Font(R.font.sfpro_bold, weight = FontWeight(500)),
   Font(R.font.sfpro_heavy),
   Font(R.font.sfpro_light),
   Font(R.font.sfpro_medium),
   Font(R.font.sfpro_regular, weight = FontWeight(300)),
   Font(R.font.sfpro_semibold),
   Font(R.font.sfpro_thin),
   Font(R.font.sfpro_ultralight)
)

// Set of Material typography styles to start with
val Typography = Typography(
   bodyLarge = TextStyle(
      fontFamily = FontFamily.Default,
      fontWeight = FontWeight.Normal,
      fontSize = 16.sp,
      lineHeight = 24.sp,
      letterSpacing = 0.5.sp
   )
   /* Other default text styles to override
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
)