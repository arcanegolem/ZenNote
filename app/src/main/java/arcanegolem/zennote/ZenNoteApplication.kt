package arcanegolem.zennote

import android.app.Application
import arcanegolem.zennote.di.appModule
import org.koin.core.context.startKoin

class ZenNoteApplication : Application() {
   override fun onCreate() {
      super.onCreate()

      startKoin {
         modules(appModule)
      }
   }
}