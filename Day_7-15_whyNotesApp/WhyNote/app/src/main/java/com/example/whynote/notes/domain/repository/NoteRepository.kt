package com.example.whynote.notes.domain.repository

import android.provider.ContactsContract
import com.example.whynote.notes.domain.models.Notes

// NoteRepository.kt
class NoteRepository {
    private val notes = mutableListOf<Notes>()

    fun getNotes(): List<Notes> = notes

    fun addNote(note: Notes) {
        notes.add(note)
    }

}
