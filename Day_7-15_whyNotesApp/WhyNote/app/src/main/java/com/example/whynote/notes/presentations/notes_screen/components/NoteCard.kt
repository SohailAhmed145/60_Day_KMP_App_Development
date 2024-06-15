package com.example.whynote.notes.presentations.notes_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.domain.models.NoteEntity

@Composable
fun NoteCard(viewModel: NoteViewModel, note: NoteEntity, navController: NavController){
    Card(
       modifier = Modifier
           .background(Color.Gray)
           .fillMaxWidth(0.5f
           )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}