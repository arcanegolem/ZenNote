package arcanegolem.zennote.presentation.screens.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import arcanegolem.zennote.data.note.components.ComponentType
import org.koin.androidx.compose.koinViewModel
import org.mongodb.kbson.ObjectId

@Composable
fun NoteScreen(vm: NoteScreenViewModel = koinViewModel(), noteId: ObjectId) {
   val note = vm.getRelatedNote(noteId)

   Column {
      if (note != null) {
         Text(text = note.title)
         LazyColumn() {
            itemsIndexed(
               note.components,
               key = { idx, component -> component.type + idx.toString() }
            ) { _, component ->
               when (component.type) {
                  ComponentType.TEXT -> {
                     BasicTextField(value = component.content, onValueChange = {})
                  }
                  ComponentType.IMAGE -> {

                  }
                  ComponentType.VOICE -> {

                  }
               }
            }
         }
      }
   }
}