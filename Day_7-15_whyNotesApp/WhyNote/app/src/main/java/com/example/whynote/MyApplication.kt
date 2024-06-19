package com.example.whynote

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.presentations.notes_screen.Destination
import com.example.whynote.notes.presentations.notes_screen.NoteDetailScreen
import com.example.whynote.notes.presentations.notes_screen.NoteScreen


@Composable
fun MyApplication(
    myViewModel: NoteViewModel,
    navController: NavHostController,
    drawerState: DrawerState
) {
    NavHost(
        navController = navController,
        startDestination = Destination.NoteScreen.toString(),
//        enterTransition = {
//            fadeIn(animationSpec = tween(900)) +
//                    slideIntoContainer(
//                        AnimatedContentTransitionScope.SlideDirection.Left,
//                        animationSpec = tween(900)
//                    )
//        },
        exitTransition = {
            fadeOut(animationSpec = tween(900)) +
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(900)
                    )
        },
//        popEnterTransition = {
//            fadeIn(animationSpec = tween(900)) +
//                    slideIntoContainer(
//                        AnimatedContentTransitionScope.SlideDirection.Right,
//                        animationSpec = tween(900)
//                    )
//        },
//        popExitTransition = {
//            fadeOut(animationSpec = tween(900)) +
//                    slideOutOfContainer(
//                        AnimatedContentTransitionScope.SlideDirection.Right,
//                        animationSpec = tween(900)
//                    )
//        },
    ) {
        composable(Destination.NoteScreen.toString()) {
            NoteScreen(viewModel = myViewModel, navController, drawerState)
        }
        composable(Destination.NoteDetailScreen.toString()) {
            NoteDetailScreen(myViewModel, navController)
        }

    }
}