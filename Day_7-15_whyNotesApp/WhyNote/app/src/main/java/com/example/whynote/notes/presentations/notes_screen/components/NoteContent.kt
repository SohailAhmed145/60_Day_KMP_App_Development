package com.example.whynote.notes.presentations.notes_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.whynote.notes.data.room.NoteViewModel

@Composable
fun NoteContent(viewModel: NoteViewModel, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxHeight(0.8f)
    ) {
        NoteList(
            viewModel,
            navController
        )
    }

}