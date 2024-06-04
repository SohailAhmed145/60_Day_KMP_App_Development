package com.example.whynote.notes.presentations.notes_screen



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.whynote.notes.presentations.util.components.BottomBar
import com.example.whynote.notes.presentations.util.components.MyTopAppBar

@Composable
fun HomeScreen(navController: NavHostController) {
       Column (
              modifier = Modifier.fillMaxSize(),
              verticalArrangement = Arrangement.SpaceBetween
       ){
              MyTopAppBar()
              BottomBar(navController = navController)
       }


}

