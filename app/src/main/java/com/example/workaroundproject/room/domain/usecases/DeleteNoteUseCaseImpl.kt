package com.example.workaroundproject.room.domain.usecases

import com.example.workaroundproject.room.domain.datastore.NoteRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


class DeleteNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
)
    : DeleteNoteUseCase {

    override suspend fun deleteNote(id: Int) {
        repository.deleteNote(id)
    }
}