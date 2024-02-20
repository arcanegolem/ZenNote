package arcanegolem.zennote.di

import arcanegolem.zennote.presentation.screens.main.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
   viewModel {
      MainScreenViewModel()
   }
}