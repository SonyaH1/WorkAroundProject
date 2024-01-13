package com.example.workaroundproject.room.domain.usecases

interface DeleteNoteUseCase {

    suspend fun deleteNote(id: Int)
}