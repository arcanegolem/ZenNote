package arcanegolem.zennote.data.note

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class NoteFolder : RealmObject {
   @PrimaryKey var _id : ObjectId = ObjectId()
   var title : String = ""
   var notes : RealmList<Note> = realmListOf()
}