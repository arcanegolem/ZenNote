package arcanegolem.zennote.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import arcanegolem.zennote.R
import arcanegolem.zennote.ui.theme.SanFrancisco

@Composable
fun Header(modifier : Modifier = Modifier, headerText: String) {

   Row(
      modifier = modifier,
      verticalAlignment = Alignment.CenterVertically
   ) {
      var textSize by remember { mutableStateOf(Size.Zero) }
      Icon(
         modifier = Modifier.size(with(LocalDensity.current) { textSize.height.toDp() / 1.3F }),
         painter = painterResource(id = R.drawable.yy_alt),
         contentDescription = "ZenNote logo",
         tint = Color.Black
      )
      Spacer(modifier = Modifier.width(12.dp))
      Text(
         modifier = Modifier.onGloballyPositioned { textSize = it.size.toSize() },
         text = headerText,
         style = TextStyle(
            fontWeight = FontWeight(500),
            fontSize = 36.sp,
            fontFamily = SanFrancisco
         ) // TODO: Add to styles
      )
   }
}