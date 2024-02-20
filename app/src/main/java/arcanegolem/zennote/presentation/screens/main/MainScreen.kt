package arcanegolem.zennote.presentation.screens.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.FolderOpen
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.NotInterested
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import arcanegolem.zennote.R
import arcanegolem.zennote.presentation.components.Header
import arcanegolem.zennote.presentation.components.SecondaryHeader
import arcanegolem.zennote.presentation.screens.main.components.MenuActionButton
import arcanegolem.zennote.presentation.screens.main.components.NoteSearchBar
import arcanegolem.zennote.presentation.screens.main.sections.Section
import arcanegolem.zennote.presentation.screens.main.sections.SectionMenu
import arcanegolem.zennote.presentation.screens.main.sections.SectionState
import kotlinx.coroutines.flow.asStateFlow
import org.koin.androidx.compose.koinViewModel


@Composable
fun MainScreen(vm : MainScreenViewModel = koinViewModel()) {
   val searchQuery = remember { mutableStateOf("") }
   val notesExist = false

   val uiState = vm.uiState.asStateFlow().collectAsState()

   val sections = listOf(
      Section(SectionState.Home,      stringResource(id = R.string.homeSection)),
      Section(SectionState.Notes,     stringResource(id = R.string.notesSection)),
      Section(SectionState.Folders,   stringResource(id = R.string.foldersSection)),
      Section(SectionState.Voice,     stringResource(id = R.string.voiceSection)),
      Section(SectionState.Documents, stringResource(id = R.string.documentsSection))
   )

   Column(
      modifier = Modifier
         .fillMaxWidth()
   ) {
      Spacer(modifier = Modifier.height(40.dp))
      Header(modifier = Modifier.padding(horizontal = 12.dp), headerText = stringResource(id = R.string.mainMenuHeader))
      NoteSearchBar(
         modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-16).dp)
            .padding(horizontal = 12.dp),
         query = searchQuery
      )
      Spacer(modifier = Modifier.height(16.dp))
      SectionMenu(sections = sections, onSectionClick = vm::updateState, uiState = uiState.value)
      Spacer(modifier = Modifier.height(32.dp))

      when (uiState.value) {
         SectionState.Home -> {
            var rowSize by remember { mutableStateOf(Size.Zero) }
            val spacerSize = 12.dp
            Row (
               modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp)
                  .onGloballyPositioned { rowSize = it.size.toSize() }
                  .animateContentSize()
            ) {
               var biggestButtonSize by remember { mutableStateOf(Size.Zero) }
               Column(
                  modifier = Modifier.width(with(LocalDensity.current) { (rowSize.width / 2).toDp() - spacerSize / 2})
               ) {
                  MenuActionButton(
                     modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { biggestButtonSize = it.size.toSize() },
                     menuActionButtonText = stringResource(id = R.string.createNewNoteButton),
                     leadingIcon = Icons.Rounded.Add
                  )
                  Spacer(modifier = Modifier.height(spacerSize))
                  MenuActionButton(
                     modifier = Modifier
                        .fillMaxWidth()
                        .height(with(LocalDensity.current) { biggestButtonSize.height.toDp() }),
                     menuActionButtonText = stringResource(id = R.string.recordAudioButton),
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
                     menuActionButtonText = stringResource(id = R.string.createNewFolderButton),
                     leadingIcon = Icons.Rounded.FolderOpen
                  )
                  Spacer(modifier = Modifier.height(spacerSize))
                  MenuActionButton(
                     modifier = Modifier
                        .fillMaxWidth()
                        .height(with(LocalDensity.current) { biggestButtonSize.height.toDp() }),
                     menuActionButtonText = stringResource(id = R.string.reservedButton),
                     leadingIcon = Icons.Rounded.NotInterested
                  )
               }
            }
            Spacer(modifier = Modifier.height(32.dp))
            if (notesExist) {
               SecondaryHeader(modifier = Modifier.padding(horizontal = 12.dp), secondaryHeaderText = "LAST UPDATED")
            }
         }
         SectionState.Notes -> {}
         SectionState.Folders -> {}
         SectionState.Voice -> {}
         SectionState.Documents -> {}
      }
   }
}