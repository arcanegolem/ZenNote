package arcanegolem.zennote.presentation.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.NotInterested
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import arcanegolem.zennote.R
import arcanegolem.zennote.presentation.components.Header
import arcanegolem.zennote.presentation.components.SecondaryHeader
import arcanegolem.zennote.presentation.screens.main.components.MenuActionButton
import arcanegolem.zennote.presentation.screens.main.components.NoteSearchBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(vm : MainScreenViewModel = koinViewModel()) {
   val searchQuery = remember { mutableStateOf("") }
   val focusManager = LocalFocusManager.current

   Column(
      modifier = Modifier
         .fillMaxWidth()
         .padding(horizontal = 12.dp)
   ) {
      Spacer(modifier = Modifier.height(20.dp))
      Header(headerText = stringResource(id = R.string.mainMenuHeader))
      NoteSearchBar(
         modifier = Modifier.fillMaxWidth(),
         query = searchQuery
      )
      Spacer(modifier = Modifier.height(24.dp))

      var rowSize by remember { mutableStateOf(Size.Zero) }
      val spacerSize = 12.dp
      Row (
         modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned { rowSize = it.size.toSize() }
      ) {
         var biggestButtonSize by remember { mutableStateOf(Size.Zero) }
         Column(
            modifier = Modifier.width(with(LocalDensity.current) { (rowSize.width / 2).toDp() - spacerSize / 2})
         ) {
            MenuActionButton(
               modifier = Modifier
                  .fillMaxWidth()
                  .onGloballyPositioned { biggestButtonSize = it.size.toSize() },
               menuActionButtonText = "Create new note",
               leadingIcon = Icons.Rounded.Add
            )
            Spacer(modifier = Modifier.height(spacerSize))
            MenuActionButton(
               modifier = Modifier
                  .fillMaxWidth()
                  .height(with(LocalDensity.current) { biggestButtonSize.height.toDp() }),
               menuActionButtonText = "Record audio",
               leadingIcon = Icons.Rounded.Mic
            )
         }
         Spacer(modifier = Modifier.width(spacerSize))
         Column(
            modifier = Modifier.width(with(LocalDensity.current) { (rowSize.width / 2).toDp() - spacerSize / 2})
         ) {
            MenuActionButton(
               modifier = Modifier
                  .fillMaxWidth()
                  .height(with(LocalDensity.current) { biggestButtonSize.height.toDp() }),
               menuActionButtonText = "Create new group",
               leadingIcon = Icons.Rounded.Add
            )
            Spacer(modifier = Modifier.height(spacerSize))
            MenuActionButton(
               modifier = Modifier
                  .fillMaxWidth()
                  .height(with(LocalDensity.current) { biggestButtonSize.height.toDp() }),
               menuActionButtonText = "Sample",
               leadingIcon = Icons.Rounded.NotInterested
            )
         }
      }
      Spacer(modifier = Modifier.height(32.dp))
      SecondaryHeader(secondaryHeaderText = "RECENTLY UPDATED")
   }
}