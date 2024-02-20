package arcanegolem.zennote.data.note.components

import io.realm.kotlin.types.EmbeddedRealmObject

class NoteComponent : EmbeddedRealmObject {
   var type : String = ""
   var content : String = ""
}