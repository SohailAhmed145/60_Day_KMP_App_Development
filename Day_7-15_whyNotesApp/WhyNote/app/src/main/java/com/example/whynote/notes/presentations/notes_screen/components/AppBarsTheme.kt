package com.example.whynote.notes.presentations.notes_screen.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppBarsTheme(){
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()
    if(darkTheme){
        systemUiController.setStatusBarColor(
            color = Color(0xFF2F3131)
        )
        systemUiController.setNavigationBarColor(
            color = Color(0xFF2F3131)
        )
    }
    else {
        systemUiController.setStatusBarColor(
            color = Color(0xFFFFFFFF)
        )
        systemUiController.setNavigationBarColor(
            color = Color(0xFFFFFFFF)
        )
    }
}
