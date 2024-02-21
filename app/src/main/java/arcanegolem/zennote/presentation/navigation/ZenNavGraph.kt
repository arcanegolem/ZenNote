package arcanegolem.zennote.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import arcanegolem.zennote.presentation.screens.main.MainScreen
import arcanegolem.zennote.presentation.screens.note.NoteScreen
import org.mongodb.kbson.ObjectId


fun NavGraphBuilder.zenNavGraph( navController: NavController ) {
   navigation(
      startDestination = MAIN,
      route = ROOT
   ) {
      composable(MAIN) { MainScreen(onNoteClick = { route -> navController.navigate(route) }) }
      composable(
         route = "$NOTE/{$NOTE_ID}",
         arguments = listOf(navArgument(NOTE_ID) { type= NavType.StringType })
      ) {
         val noteId = it.arguments?.getString(NOTE_ID)
         NoteScreen(noteId=ObjectId(noteId!!))
      }
   }
}