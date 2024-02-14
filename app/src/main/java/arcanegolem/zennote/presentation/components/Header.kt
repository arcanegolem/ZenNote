package arcanegolem.zennote.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Header(headerText: String) {
   Text(
      text = headerText,
      style = TextStyle(fontWeight = FontWeight(700), fontSize = 36.sp) // TODO: Add to styles
   )
}