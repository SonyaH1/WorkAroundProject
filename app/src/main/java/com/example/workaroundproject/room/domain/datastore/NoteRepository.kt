package com.example.workaroundproject.room.domain.datastore

import com.example.workaroundproject.room.domain.entities.NoteItem
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun observeNotes(): Flow<List<NoteItem>>

    suspend fun insertNote(noteItem: NoteItem)

    suspend fun deleteNote(id: Int)
}