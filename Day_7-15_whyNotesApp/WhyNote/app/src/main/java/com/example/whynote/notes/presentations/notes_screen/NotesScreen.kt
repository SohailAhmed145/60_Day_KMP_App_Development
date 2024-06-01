package com.example.whynote.notes.presentations.notes_screen

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.whynote.notes.domain.models.Notes

import com.example.whynote.notes.presentations.notes_screen.components.NotesItem
import com.example.whynote.notes.presentations.util.components.MyTopAppBar
import com.example.whynote.ui.theme.secondaryContainerLight

@Composable
fun NotesScreen(viewModel: NoteViewModel) {

       MyTopAppBar()

    val notes by remember { mutableStateOf(viewModel.notes) }
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        NoteInput(
            title = title,
            content = content,
            onTitleChange = { title = it },
            onContentChange = { content = it },
            onAddNote = {
                viewModel.addNote(Notes(
                    id = notes.size + 1,
                    title = title,
                    content = content
                ))
                title = ""
                content = ""
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        NoteList(notes)
    }
}

@Composable
fun NoteInput(
    title: String,
    content: String,
    onTitleChange: (String) -> Unit,
    onContentChange: (String) -> Unit,
    onAddNote: () -> Unit
) {
    Column {
        BasicTextField(
            value = title,
            onValueChange = onTitleChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                if (title.isEmpty()) {
                    Text("Title", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f))
                }
                innerTextField()
            }
        )
        BasicTextField(
            value = content,
            onValueChange = onContentChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                if (content.isEmpty()) {
                    Text("Content", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f))
                }
                innerTextField()
            }
        )
        Button(onClick = onAddNote, modifier = Modifier.align(Alignment.End)) {
            Text("Add Note")
        }
    }
}

@Composable
fun NoteList(notes: List<Notes>) {
    Column {
        for (note in notes) {
            NoteItem(note)
            Divider()
        }
    }
}

@Composable
fun NoteItem(note: Notes) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = note.title, style = MaterialTheme.typography.headlineSmall)
        Text(text = note.content, style = MaterialTheme.typography.bodyLarge)
    }
}

