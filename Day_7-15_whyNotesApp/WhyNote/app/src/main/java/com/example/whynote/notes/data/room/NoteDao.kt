package com.example.whynote.notes.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.whynote.notes.domain.models.NoteEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {
    @Insert
    suspend fun addNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM NoteEntity")
    fun getAllNotes(): Flow<List<NoteEntity>>
}