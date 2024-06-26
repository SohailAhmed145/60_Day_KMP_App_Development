package com.example.whynote.notes.presentations.notes_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.domain.models.NoteEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(viewModel: NoteViewModel, note: NoteEntity, navController: NavController){
    Card(
        onClick = {
            navController.navigate("NoteDetailScreen")
        },
        modifier = Modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(10.dp)
            )
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .border((0.5).dp, Color.Gray, RoundedCornerShape(18.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.title,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
            )
            Text(
                text = note.noteContent,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 15.sp,
            )
        }
    }
}

@Composable
fun NoteList(viewModel: NoteViewModel, navController: NavHostController){

    val notes by viewModel.notes.collectAsState(initial = emptyList())

    LazyVerticalStaggeredGrid(
        modifier = Modifier.padding(start = 5.dp, end = 5.dp),
        columns = StaggeredGridCells.Fixed(2)) {
        items(items = notes){
            item -> NoteCard(
                viewModel,
                note = item,
               navController
            )
        }


    }

}