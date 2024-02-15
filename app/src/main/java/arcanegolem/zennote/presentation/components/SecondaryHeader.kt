package arcanegolem.zennote.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import arcanegolem.zennote.ui.theme.SanFrancisco

@Composable
fun SecondaryHeader(modifier : Modifier = Modifier, secondaryHeaderText : String) {
   Text(
      modifier = modifier,
      text = secondaryHeaderText,
      style = TextStyle(fontWeight = FontWeight(500), fontSize = 20.sp, fontFamily = SanFrancisco)
   )
}