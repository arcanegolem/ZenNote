package arcanegolem.zennote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import arcanegolem.zennote.ui.theme.ZenNoteTheme

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent { ZenNoteApp() }
   }
}