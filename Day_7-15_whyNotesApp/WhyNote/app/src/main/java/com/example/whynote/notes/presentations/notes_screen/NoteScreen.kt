package com.example.whynote.notes.presentations.notes_screen



import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.presentations.notes_screen.components.NoteContent
import com.example.whynote.notes.presentations.util.components.BottomBar
import com.example.whynote.notes.presentations.util.components.MyTopAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteScreen(viewModel: NoteViewModel,navController: NavHostController) {
//       Column (
//              modifier = Modifier.fillMaxSize(),
//              verticalArrangement = Arrangement.SpaceBetween
//       ){
//              MyTopAppBar()
//              NoteContent(viewModel, navController)
//              BottomBar(navController)
//       }
       Scaffold(
              modifier = Modifier.fillMaxSize(),
              containerColor = MaterialTheme.colorScheme.onPrimary,
              topBar = {
                     MyTopAppBar()
              },
              bottomBar = {
                     BottomBar(navController)
              },
       ) {
              NoteContent(viewModel, navController)
       }


}

