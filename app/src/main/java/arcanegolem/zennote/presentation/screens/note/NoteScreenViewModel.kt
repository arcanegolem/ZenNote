package arcanegolem.zennote.presentation.screens.note

import androidx.lifecycle.ViewModel
import arcanegolem.zennote.data.note.Note
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import org.mongodb.kbson.ObjectId

class NoteScreenViewModel(private val realm : Realm) : ViewModel() {

   fun getRelatedNote(id : ObjectId) = realm
      .query<Note>("_id == $0", id)
      .first()
      .find()
}