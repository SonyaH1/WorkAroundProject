package com.example.workaroundproject.room.domain.usecases

import com.example.workaroundproject.room.domain.datastore.NoteRepository
import com.example.workaroundproject.room.domain.entities.NoteItem
import kotlinx.coroutines.flow.Flow

class ObserveListOfNotesUseCaseImpl(private val repository: NoteRepository)
    : ObserveListOfNotesUseCase {

    override fun observeListOfNotes(): Flow<List<NoteItem>> {
        return repository.observeNotes()
    }
}