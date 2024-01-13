package com.example.workaroundproject.room.domain.usecases

import com.example.workaroundproject.room.domain.entities.NoteItem

interface InsertNoteUseCase {

    suspend fun insertNote(noteItem: NoteItem)
}