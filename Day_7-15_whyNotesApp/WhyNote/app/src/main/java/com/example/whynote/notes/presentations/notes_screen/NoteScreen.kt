package com.example.whynote.notes.presentations.notes_screen



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.presentations.notes_screen.components.NoteContent
import com.example.whynote.notes.presentations.util.components.BottomBar
import com.example.whynote.notes.presentations.util.components.MyTopAppBar

@Composable
fun NoteScreen(viewModel: NoteViewModel,navController: NavHostController) {
       Column (
              modifier = Modifier.fillMaxSize(),
              verticalArrangement = Arrangement.SpaceBetween
       ){
              MyTopAppBar()
              NoteContent(viewModel, navController)
              BottomBar(navController)
       }


}

