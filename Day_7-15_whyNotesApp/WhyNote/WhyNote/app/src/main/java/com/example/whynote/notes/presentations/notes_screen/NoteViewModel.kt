package com.example.whynote.notes.presentations.notes_screen


import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.whynote.notes.domain.models.Notes
import com.example.whynote.notes.domain.repository.NoteRepository

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    private val _notes: SnapshotStateList<Notes> = mutableStateListOf()

    val notes: List<Notes> get() = _notes

    init {
        _notes.addAll(repository.getNotes())
    }

    fun addNote(note: Notes) {
        repository.addNote(note)
        _notes.add(note)
    }
}

class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
