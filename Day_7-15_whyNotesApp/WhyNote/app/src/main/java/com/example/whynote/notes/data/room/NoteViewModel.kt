package com.example.whynote.notes.data.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whynote.notes.domain.models.NoteEntity
import com.example.whynote.notes.domain.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel (val repository: NoteRepository): ViewModel() {

    fun addNote(note: NoteEntity){
        viewModelScope.launch {
            repository.addNoteToRoom(note)
        }
    }
}