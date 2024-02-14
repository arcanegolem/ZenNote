package arcanegolem.zennote.presentation.screens.main.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import arcanegolem.zennote.R

// TODO: Change searchbar to text field and manage focus
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteSearchBar(
   query : MutableState<String>,
   modifier : Modifier = Modifier
) {
   SearchBar(
      colors = SearchBarDefaults.colors( containerColor = colorResource(id = R.color.searchbar_container) ),
      modifier = modifier,
      query = query.value,
      onQueryChange = {input -> query.value = input},
      onSearch = {},
      active = false,
      onActiveChange = {},
      leadingIcon = {
         Icon(
            tint = Color.LightGray,
            imageVector = Icons.Rounded.Search,
            contentDescription = "Search icon"
         )
      },
      placeholder = {
         Text(
            text = "Search notes",
            style = TextStyle(color = Color.LightGray)
         )
      },
      shape = RoundedCornerShape(16.dp)
   ) {}
}