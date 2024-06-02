package com.example.whynote.notes.presentations.notes_screen



import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.whynote.notes.domain.models.Notes
import com.example.whynote.notes.presentations.util.components.MyTopAppBar

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
    onAddNote: () -> Unit,
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

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(notes) { note ->
        NoteItem(note)
        Divider()

        }
    }
}


@Composable
fun NoteItem(note: Notes) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(Color(0xFF5F6368))
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimary)
            Text(
                text = note.content,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}

