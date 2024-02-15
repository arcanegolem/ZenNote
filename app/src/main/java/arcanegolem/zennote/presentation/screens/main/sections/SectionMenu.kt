package arcanegolem.zennote.presentation.screens.main.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import arcanegolem.zennote.ui.theme.SanFrancisco

@Composable
fun SectionMenu(sections : List<Section>, onSectionClick : (SectionState) -> Unit) {
   LazyRow() {
      items(sections) { section ->
         Spacer(modifier = Modifier.width(if (sections.first() == section) 12.dp else 6.dp))
         OutlinedButton(
            shape = RoundedCornerShape(100),
            onClick = { onSectionClick(section.state) },
            border = BorderStroke(width = (0.8).dp, color = Color.LightGray),
         ) {
            Text(text = section.name)
         }
         Spacer(modifier = Modifier.width(if (sections.last() == section) 12.dp else 0.dp))
      }
   }
}

@Composable
fun SectionMenu(
   modifier : Modifier = Modifier,
   sections : List<Section>,
   onSectionClick : (SectionState) -> Unit,
   uiState: SectionState
) {
   Column(modifier = modifier) {
      val interactionSource = MutableInteractionSource()
      LazyRow(modifier = Modifier.fillMaxWidth()) {
         items(sections) { section ->
            Spacer(modifier = Modifier.width(if (sections.first() == section) 12.dp else 28.dp))
            Column(
               modifier = Modifier.clickable(
                  interactionSource,
                  null
               ) { onSectionClick(section.state) }
            ) {
               var textSize by remember { mutableStateOf(Size.Zero) }
               Text(
                  modifier = Modifier.onGloballyPositioned { textSize = it.size.toSize() },
                  text = section.name,
                  fontWeight = FontWeight(300),
                  fontFamily = SanFrancisco
               )
               Spacer(modifier = Modifier.height(with(LocalDensity.current) { textSize.height.toDp() / 1.5F }))
               if (uiState == section.state) {
                  Box(
                     modifier = Modifier
                        .width(with(LocalDensity.current) { textSize.width.toDp() })
                        .height(3.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(50))
                  )
               }
            }
            Spacer(modifier = Modifier.width(if (sections.last() == section) 12.dp else 0.dp))
         }
      }
      Divider(thickness = 1.dp)
   }
}