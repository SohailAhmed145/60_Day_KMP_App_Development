package com.example.whynote.notes.presentations.notes_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.domain.models.NoteEntity
import com.example.whynote.notes.presentations.notes_screen.components.NoteDetailBottomToolBar
import com.example.whynote.notes.presentations.notes_screen.components.NoteDetailTopToolBar


@Composable
fun NoteDetailScreen(viewModel: NoteViewModel,navController: NavHostController){

    var inputTitle by remember{ mutableStateOf("") }
    var inputNoteContent by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary),
    ) {
        NoteDetailTopToolBar(viewModel, navController)
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){

            OutlinedTextField(
                value = inputTitle,
                onValueChange = {
                        enteredText -> inputTitle = enteredText
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f)
                    .wrapContentHeight(unbounded = true),

                placeholder = {
                    Text(
                        text = "Title",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                },
                minLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )


            OutlinedTextField(
                value = inputNoteContent,
                onValueChange = {
                        enteredText -> inputNoteContent = enteredText
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f)
                    .background(MaterialTheme.colorScheme.onPrimary),

                placeholder = {
                    Text(
                        text = "Title",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.outline
                    )
                },
                minLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Button(onClick = {
                viewModel.addNote(NoteEntity(0,inputTitle,inputNoteContent))
            }) {
                Text(text = "Save")
            }
        }
        NoteDetailBottomToolBar()

    }

}

