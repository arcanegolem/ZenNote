package arcanegolem.zennote.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arcanegolem.zennote.data.note.Note
import arcanegolem.zennote.data.note.components.ComponentType
import arcanegolem.zennote.data.note.components.NoteComponent
import arcanegolem.zennote.presentation.screens.main.sections.SectionState
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainScreenViewModel(private val realm: Realm) : ViewModel() {

   val uiState : MutableStateFlow<SectionState> =
      MutableStateFlow(SectionState.Home)
   val notes = realm
      .query<Note>()
      .asFlow()
      .map { results -> results.list.toList() }
      .stateIn(
         viewModelScope,
         SharingStarted.WhileSubscribed(),
         emptyList()
      )

   init {
      Log.i("MainScreenViewModel", "Initialized!")
//      mockEntry()
   }

   private fun mockEntry() {
      viewModelScope.launch(Dispatchers.IO) {
         realm.write {
            val note = Note().apply {
               title = "TestNoteShouldBeOutNew"
            }

            val textComponent = NoteComponent().apply {
               type = ComponentType.TEXT
               content = "Some content"
            }

            note.components.add(textComponent)
            copyToRealm(note, UpdatePolicy.ALL)
         }
      }
   }

   fun updateState(state: SectionState) {
      if (state != uiState.value) {
         uiState.value = state
      }
   }
}