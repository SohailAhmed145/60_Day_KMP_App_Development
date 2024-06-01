package com.example.whynote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.compose.WhyNoteTheme
import com.example.whynote.notes.domain.repository.NoteRepository
import com.example.whynote.notes.presentations.notes_screen.NoteViewModel
import com.example.whynote.notes.presentations.notes_screen.NoteViewModelFactory
import com.example.whynote.notes.presentations.notes_screen.NotesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Thread.sleep(1000)
        installSplashScreen()
        val repository = NoteRepository()
        val viewModelFactory = NoteViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(NoteViewModel::class.java)
        setContent {
            WhyNoteTheme {
                Scaffold (
                    
                ){innerPadding ->
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.primary)
                    ){
                       NotesScreen(viewModel)

                    }

                }

            }
        }
    }
}
