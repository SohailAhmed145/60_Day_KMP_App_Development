package com.example.whynote.notes.presentations.notes_screen.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.whynote.notes.data.room.NoteViewModel

@Composable
fun NoteContent(viewModel: NoteViewModel, navController: NavHostController) {
    NoteList(
        viewModel,
        navController
    )
}