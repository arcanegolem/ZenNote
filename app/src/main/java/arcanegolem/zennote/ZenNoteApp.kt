package arcanegolem.zennote

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import arcanegolem.zennote.presentation.navigation.ROOT
import arcanegolem.zennote.presentation.navigation.zenNavGraph
import arcanegolem.zennote.ui.theme.ZenNoteTheme

@Composable
fun ZenNoteApp() {
   val navController = rememberNavController()
   ZenNoteTheme {
      Scaffold(
         topBar = {  }
      ) { paddingValues ->
         NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = ROOT,
         ) { zenNavGraph(navController) }
      }
   }
}