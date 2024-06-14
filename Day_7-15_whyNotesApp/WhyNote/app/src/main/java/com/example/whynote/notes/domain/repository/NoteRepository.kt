package com.example.whynote.notes.domain.repository

import com.example.whynote.notes.domain.models.NoteEntity
import com.example.whynote.notes.data.room.NotesDB

class NoteRepository (val notesDB: NotesDB){
    suspend fun addNoteToRoom(noteEntity: NoteEntity){
        notesDB.noteDao().addNote(noteEntity)
    }

    fun getAllNotes() = notesDB.noteDao().getAllNotes()
}
