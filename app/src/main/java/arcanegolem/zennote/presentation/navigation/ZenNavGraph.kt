package arcanegolem.zennote.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import arcanegolem.zennote.presentation.screens.main.MainScreen


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