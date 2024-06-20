package com.example.whynote

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.data.room.NotesDB
import com.example.whynote.notes.domain.repository.NoteRepository
import com.example.whynote.notes.presentations.navigation_drawer.NavigationDrawer
import com.example.whynote.ui.theme.WhyNoteTheme
import com.example.whynote.notes.presentations.notes_screen.components.AppBarsTheme


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(100)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {

            WhyNoteTheme {
                AppBarsTheme()
                val mContext = LocalContext.current
                val db = NotesDB.getInstance(mContext)
                val repository = NoteRepository(db)
                val myViewModel = NoteViewModel(repository = repository)
                val navController = rememberNavController()



                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.onPrimary)
                    ) {
                        NavigationDrawer(myViewModel, navController)
                    }

                }
            }
        }
    }
}






