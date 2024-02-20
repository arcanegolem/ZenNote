package arcanegolem.zennote

import android.app.Application
import arcanegolem.zennote.data.note.Note
import arcanegolem.zennote.data.note.components.NoteComponent
import arcanegolem.zennote.di.appModule
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ZenNoteApplication : Application() {
   companion object {
      lateinit var realm : Realm
   }

   override fun onCreate() {
      super.onCreate()

      realm = Realm.open(
         configuration = RealmConfiguration.create(
            schema = setOf(
               Note::class,
               NoteComponent::class
            )
         )
      )

      startKoin {
         androidContext(this@ZenNoteApplication)
         modules(appModule)
      }
   }


}