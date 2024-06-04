package com.example.whynote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whynote.notes.presentations.notes_screen.Destination
import com.example.whynote.notes.presentations.notes_screen.HomeScreen
import com.example.whynote.ui.theme.WhyNoteTheme
import com.example.whynote.notes.presentations.notes_screen.components.AppBarsTheme
import com.example.whynote.notes.presentations.notes_screen.components.NoteDetailScreen



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(100)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {

            WhyNoteTheme {
               AppBarsTheme()

                Scaffold (
                    floatingActionButtonPosition = FabPosition.End,
                ){innerPadding ->
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.onPrimary)
                    ){
                       MyApp()

                    }

                }

            }
        }
    }
}

@Composable
fun MyApp() {
    MyNavigation()
}

@Composable
fun MyNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.HomeScreen.toString()) {
        composable(Destination.HomeScreen.toString()) {
            HomeScreen(navController)
        }
        composable(Destination.NoteDetailScreen.toString()) {
            NoteDetailScreen(navController)
        }
    }
}

