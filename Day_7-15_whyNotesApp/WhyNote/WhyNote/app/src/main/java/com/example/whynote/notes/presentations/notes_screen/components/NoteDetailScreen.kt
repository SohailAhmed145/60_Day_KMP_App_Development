package com.example.whynote.notes.presentations.notes_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun NoteDetailScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
    ){
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Title")
            }
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Note")
            }
        )
    }
}
