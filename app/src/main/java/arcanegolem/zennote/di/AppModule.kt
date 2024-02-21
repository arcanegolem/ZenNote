package arcanegolem.zennote.di

import arcanegolem.zennote.data.note.Note
import arcanegolem.zennote.data.note.NoteFolder
import arcanegolem.zennote.data.note.components.NoteComponent
import arcanegolem.zennote.presentation.screens.main.MainScreenViewModel
import arcanegolem.zennote.presentation.screens.note.NoteScreenViewModel
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
   viewModel { MainScreenViewModel(get()) }
   viewModel { NoteScreenViewModel(get()) }

   single<Realm> {
      Realm.open(
         configuration = RealmConfiguration.create(
            schema = setOf(
               Note::class,
               NoteComponent::class,
               NoteFolder::class
            )
         )
      )
   }
}