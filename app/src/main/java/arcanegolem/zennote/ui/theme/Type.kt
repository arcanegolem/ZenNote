package arcanegolem.zennote.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import arcanegolem.zennote.R

val SanFrancisco = FontFamily(
   Font(R.font.sfpro_black,      weight = FontWeight(600)),
   Font(R.font.sfpro_bold,       weight = FontWeight(550)),
   Font(R.font.sfpro_heavy,      weight = FontWeight(500)),
   Font(R.font.sfpro_light,      weight = FontWeight(450)),
   Font(R.font.sfpro_medium,     weight = FontWeight(400)),
   Font(R.font.sfpro_regular,    weight = FontWeight(350)),
   Font(R.font.sfpro_semibold,   weight = FontWeight(300)),
   Font(R.font.sfpro_thin,       weight = FontWeight(250)),
   Font(R.font.sfpro_ultralight, weight = FontWeight(200))
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