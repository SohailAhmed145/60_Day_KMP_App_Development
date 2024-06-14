package com.example.whynote.notes.presentations.notes_screen



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.whynote.notes.presentations.util.components.BottomBar
import com.example.whynote.notes.presentations.util.components.MyTopAppBar

@Composable
fun NoteScreen(navController: NavHostController) {
       Column (
              modifier = Modifier.fillMaxSize(),
              verticalArrangement = Arrangement.SpaceBetween
       ){
              MyTopAppBar()
              BottomBar(navController = navController)
       }


}

