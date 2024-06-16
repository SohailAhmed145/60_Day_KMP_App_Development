package com.example.whynote.notes.presentations.notes_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.whynote.notes.presentations.notes_screen.Destination
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

@Composable
fun Fab(navController: NavController) {

   Box(
       modifier = Modifier
           .fillMaxWidth()
           .padding(end = 20.dp, bottom = 25.dp),
       contentAlignment = Alignment.BottomEnd
   ){
       FloatingActionButton(
           onClick = {
               navController.navigate(Destination.NoteDetailScreen.toString())
           },
           containerColor = MaterialTheme.colorScheme.secondaryContainer,
           elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(5.dp)
       ) {
           Icon(
               imageVector = Icons.Filled.Add,
               contentDescription = "Add new Note",
               tint = MaterialTheme.colorScheme.primary,
               modifier = Modifier.size(40.dp)
           )
       }
   }


}