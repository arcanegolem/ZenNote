package arcanegolem.zennote.presentation.screens.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuActionButton(
   modifier: Modifier = Modifier,
   menuActionButtonText : String,
   leadingIcon : ImageVector,
   onMenuActionButtonClick : () -> Unit = {}
) {
   OutlinedButton(
      modifier = modifier,
      border = BorderStroke(width = (0.8).dp, color = Color.LightGray),
      onClick = onMenuActionButtonClick,
      shape = RoundedCornerShape(8.dp),
      contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 16.dp),
      colors = ButtonDefaults.buttonColors(contentColor = Color.DarkGray, containerColor = Color.Transparent)
   ) {
      Row (
         modifier = Modifier.fillMaxWidth(),
         horizontalArrangement = Arrangement.Start,
         verticalAlignment = Alignment.CenterVertically
      ){
         Icon(
            modifier = Modifier
               .padding(horizontal = 8.dp)
               .size(32.dp),
            imageVector = leadingIcon,
            contentDescription = "ActionIcon"
         )
         Text(
            text = menuActionButtonText,
            maxLines = 2,
            style = TextStyle(fontWeight = FontWeight(500), fontSize = 18.sp)
         )
      }
   }
}