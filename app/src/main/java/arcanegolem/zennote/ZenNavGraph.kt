package arcanegolem.zennote

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import arcanegolem.zennote.presentation.screens.MainScreen

const val ROOT = "root"

const val MAIN = "main"

fun NavGraphBuilder.zenNavGraph( navController: NavController ) {
   navigation(
      startDestination = MAIN,
      route = ROOT
   ) {
      composable(MAIN) {
         MainScreen()
      }
   }
}