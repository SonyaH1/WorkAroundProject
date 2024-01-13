package com.example.workaroundproject.room.domain.usecases

import com.example.workaroundproject.room.domain.datastore.NoteRepository

class DeleteNoteUseCaseImpl(private val repository: NoteRepository)
    : DeleteNoteUseCase {

    override suspend fun deleteNote(id: Int) {
        repository.deleteNote(id)
    }
}