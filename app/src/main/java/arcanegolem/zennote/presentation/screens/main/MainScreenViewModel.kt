package arcanegolem.zennote.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import arcanegolem.zennote.presentation.screens.main.sections.SectionState
import kotlinx.coroutines.flow.MutableStateFlow

class MainScreenViewModel : ViewModel() {

   val uiState : MutableStateFlow<SectionState> =
      MutableStateFlow(SectionState.Home)

   init {
      Log.i("MainScreenViewModel", "Initialized!")
   }

   fun updateState(state: SectionState) {
      uiState.value = state
   }
}