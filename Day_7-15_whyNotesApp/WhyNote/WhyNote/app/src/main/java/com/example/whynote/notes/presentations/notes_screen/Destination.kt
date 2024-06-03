package com.example.whynote.notes.presentations.notes_screen

interface Destination{
    val route : String
}
object HomeScreen : Destination {
    override val route = "Home"
}
object NoteDetailScreen : Destination {
    override val route = "NoteDetail"



}