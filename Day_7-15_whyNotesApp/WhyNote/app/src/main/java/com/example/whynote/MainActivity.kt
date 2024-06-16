package com.example.whynote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.data.room.NotesDB
import com.example.whynote.notes.domain.repository.NoteRepository
import com.example.whynote.notes.presentations.notes_screen.Destination
import com.example.whynote.ui.theme.WhyNoteTheme
import com.example.whynote.notes.presentations.notes_screen.components.AppBarsTheme
import com.example.whynote.notes.presentations.notes_screen.NoteDetailScreen
import com.example.whynote.notes.presentations.notes_screen.NoteScreen
import com.example.whynote.notes.presentations.notes_screen.components.Fab
import com.example.whynote.notes.presentations.notes_screen.components.NoteContent
import com.example.whynote.notes.presentations.util.components.BottomBar
import com.example.whynote.notes.presentations.util.components.MyTopAppBar


class MainActivity : ComponentActivity() {

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

                Scaffold (
                    floatingActionButtonPosition = FabPosition.End,
                ){innerPadding ->
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.onPrimary)
                    ){
                        NavHost(
                            navController = navController,
                            startDestination = Destination.NoteScreen.toString(),
                            enterTransition = { fadeIn(animationSpec = tween(900)) +
                                    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(900)) },
                            exitTransition = { fadeOut(animationSpec = tween(900)) +
                                    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(900)) },
                            popEnterTransition = { fadeIn(animationSpec = tween(900)) +
                                    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(900)) },
                            popExitTransition = { fadeOut(animationSpec = tween(900)) +
                                    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(900)) },
                        ) {
                            composable(Destination.NoteScreen.toString()) {
                                NoteScreen(viewModel = myViewModel ,navController)
                            }
                            composable(Destination.NoteDetailScreen.toString()) {
                                NoteDetailScreen(myViewModel,navController)
                            }

                        }
                    }

                }

            }
        }
    }
}


