package com.example.whynote

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.data.room.NotesDB
import com.example.whynote.notes.domain.repository.NoteRepository
import com.example.whynote.notes.presentations.navigation_drawer.NavigationDrawer
import com.example.whynote.notes.presentations.notes_screen.Destination
import com.example.whynote.ui.theme.WhyNoteTheme
import com.example.whynote.notes.presentations.notes_screen.components.AppBarsTheme
import com.example.whynote.notes.presentations.notes_screen.NoteDetailScreen
import com.example.whynote.notes.presentations.notes_screen.NoteScreen
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
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
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)



                Scaffold(

                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.onPrimary)
                    ) {
                        MyApplication(myViewModel, navController, drawerState )
                    }

                }
            }
        }
    }
}






