package com.example.workaroundproject.room.domain.usecases

import com.example.workaroundproject.room.domain.entities.NoteItem
import kotlinx.coroutines.flow.Flow

interface ObserveListOfNotesUseCase {

    fun observeListOfNotes() : Flow<List<NoteItem>>
}