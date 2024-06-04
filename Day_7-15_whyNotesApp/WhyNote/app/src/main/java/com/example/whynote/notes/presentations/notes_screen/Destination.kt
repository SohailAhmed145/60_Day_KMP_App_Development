package com.example.whynote.notes.presentations.notes_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(val route: String){
    data object HomeScreen : Destination("HomeScreen")
    data object NoteDetailScreen : Destination("NoteDetailScreen")
}


//interface Destination{
//    val route : String
//}
//object HomeScreen : Destination {
//    override val route = "Home"
//}
//object NoteDetailScreen : Destination {
//    override val route = "NoteDetail"
//}