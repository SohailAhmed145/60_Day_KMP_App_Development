package com.example.whynote.notes.presentations.util.components




import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.whynote.R
import com.example.whynote.notes.presentations.notes_screen.NoteViewModel


@Composable
fun BottomBar() {
   BottomAppBar(
       containerColor = MaterialTheme.colorScheme.secondaryContainer,
       modifier = Modifier.height(100.dp),
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Outlined.Check, contentDescription = "make list")
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(R.drawable.brush),
                    contentDescription = "draw a note",
                )
            }

            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(R.drawable.image),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "Localized description",
                )
            }
        },
       )

}

