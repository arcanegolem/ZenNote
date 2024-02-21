package arcanegolem.zennote.data.note

import arcanegolem.zennote.data.note.components.NoteComponent
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Note : RealmObject {
   @PrimaryKey var _id: ObjectId = ObjectId()
   var title : String = ""
   var components : RealmList<NoteComponent> = realmListOf()
}