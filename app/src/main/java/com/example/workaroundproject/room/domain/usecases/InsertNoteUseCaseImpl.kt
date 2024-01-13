package com.example.workaroundproject.room.domain.usecases

import com.example.workaroundproject.room.domain.datastore.NoteRepository
import com.example.workaroundproject.room.domain.entities.NoteItem

//todo move map here
class InsertNoteUseCaseImpl(private val repository: NoteRepository) : InsertNoteUseCase {
    override suspend fun insertNote(noteItem: NoteItem) {
        repository.insertNote(noteItem)
    }
}