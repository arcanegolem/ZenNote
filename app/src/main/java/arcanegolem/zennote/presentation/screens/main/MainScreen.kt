package arcanegolem.zennote.presentation.screens.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.FolderOpen
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.NotInterested
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import arcanegolem.zennote.R
import arcanegolem.zennote.presentation.components.Header
import arcanegolem.zennote.presentation.components.SecondaryHeader
import arcanegolem.zennote.presentation.navigation.NOTE
import arcanegolem.zennote.presentation.screens.main.components.MenuActionButton
import arcanegolem.zennote.presentation.screens.main.components.NoteSearchBar
import arcanegolem.zennote.presentation.screens.main.sections.Section
import arcanegolem.zennote.presentation.screens.main.sections.SectionMenu
import arcanegolem.zennote.presentation.screens.main.sections.SectionState
import kotlinx.coroutines.flow.asStateFlow
import org.koin.androidx.compose.koinViewModel


@Composable
fun MainScreen(vm : MainScreenViewModel = koinViewModel(), onNoteClick: (String) -> Unit) {
   val searchQuery = remember { mutableStateOf("") }
   val uiState = vm.uiState.asStateFlow().collectAsState()
   val notes = vm.notes.collectAsState()

   val sections = listOf(
      Section(SectionState.Home,      stringResource(id = R.string.homeSection)),
      Section(SectionState.Notes,     stringResource(id = R.string.notesSection)),
      Section(SectionState.Folders,   stringResource(id = R.string.foldersSection)),
      Section(SectionState.Voice,     stringResource(id = R.string.voiceSection)),
      Section(SectionState.Documents, stringResource(id = R.string.documentsSection))
   )

   Column(
      modifier = Modifier
         .fillMaxSize()
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
            if (notes.value.isNotEmpty()) {
               Spacer(modifier = Modifier.height(32.dp))
               SecondaryHeader(
                  modifier = Modifier.padding(horizontal = 12.dp),
                  secondaryHeaderText = stringResource(id = R.string.mainMenuSecondHeader)
               )
               Spacer(modifier = Modifier.height(16.dp))
               LazyColumn(
                  modifier = Modifier
                     .padding(horizontal = 12.dp)
                     .animateContentSize()
               ) {
                  val subList =
                     if (notes.value.size < 5) notes.value.sortedBy { it._id } else notes.value.sortedBy { it._id }
                        .subList(0, 5)
                  items(subList) {
                     Text(text = it.title) // TODO: Change for dedicated component
                  }
               }
            }
         }
         SectionState.Notes -> {
            Box(
               modifier = Modifier
                  .fillMaxSize()
                  .padding(horizontal = 12.dp)
            ){
               LazyColumn(
                  modifier = Modifier.fillMaxWidth()
               ) {
                  items(notes.value) {
                     Button(onClick = { onNoteClick("$NOTE/${it._id.toHexString()}") })
                     { Text(text = it.title) } // TODO: Change for dedicated component
                  }
               }
               FloatingActionButton(
                  modifier = Modifier
                     .align(Alignment.BottomEnd)
                     .padding(bottom = 24.dp, end = 12.dp),
                  onClick = { /*TODO*/ },
                  containerColor = Color.Black, // TODO: Awh theming awaits
                  contentColor = Color.White
               ) {
                  Icon(imageVector = Icons.Rounded.Add, contentDescription = "add note icon")
               }
            }
         }
         SectionState.Folders -> {}
         SectionState.Voice -> {}
         SectionState.Documents -> {}
      }
   }
}