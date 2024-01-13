package com.example.workaroundproject.room.domain.usecases

import com.example.workaroundproject.room.domain.datastore.NoteRepository
import com.example.workaroundproject.room.domain.entities.NoteItem
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

//todo move map here

class InsertNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : InsertNoteUseCase {
    override suspend fun insertNote(noteItem: NoteItem) {
        repository.insertNote(noteItem)
    }
}