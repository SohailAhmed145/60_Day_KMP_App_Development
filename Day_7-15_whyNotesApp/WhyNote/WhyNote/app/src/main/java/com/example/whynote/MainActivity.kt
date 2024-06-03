package com.example.whynote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whynote.notes.presentations.notes_screen.HomeScreen
import com.example.whynote.ui.theme.WhyNoteTheme
import com.example.whynote.notes.presentations.notes_screen.NoteDetailScreen
import com.example.whynote.notes.presentations.notes_screen.components.AppBarsTheme
import com.example.whynote.notes.presentations.notes_screen.components.NoteDetailScreen
import com.example.whynote.notes.presentations.util.components.BottomBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(100)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {

            WhyNoteTheme {
               AppBarsTheme()
                val navController = rememberNavController()
                Scaffold (
                    floatingActionButton = {

                        FloatingActionButton(
                            onClick = {
                                navController.navigate("NoteDetail")
                            },
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(5.dp)
                        ) {
                            Icon(
                                Icons.Outlined.Add,
                                "Add new Note",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    },
                    floatingActionButtonPosition = FabPosition.End,
                    bottomBar = {
                        BottomBar()
                    }
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
fun MyApp(){
    MyNavigation()
}

@Composable
fun MyNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen.route) {
        composable(HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(NoteDetailScreen.route) {
            NoteDetailScreen(navController)
        }
    }
}

