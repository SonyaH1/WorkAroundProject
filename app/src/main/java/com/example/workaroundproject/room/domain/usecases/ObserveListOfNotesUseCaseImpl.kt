package com.example.workaroundproject.room.domain.usecases

import com.example.workaroundproject.room.domain.datastore.NoteRepository
import com.example.workaroundproject.room.domain.entities.NoteItem
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ObserveListOfNotesUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
)
    : ObserveListOfNotesUseCase {

    override fun observeListOfNotes(): Flow<List<NoteItem>> {
        return repository.observeNotes()
    }
}