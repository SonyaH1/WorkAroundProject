package com.example.workaroundproject.room.di

import com.example.workaroundproject.room.data.NoteRepositoryImpl
import com.example.workaroundproject.room.db.NoteDatabase
import com.example.workaroundproject.room.domain.datastore.NoteRepository
import com.example.workaroundproject.room.domain.usecases.DeleteNoteUseCase
import com.example.workaroundproject.room.domain.usecases.DeleteNoteUseCaseImpl
import com.example.workaroundproject.room.domain.usecases.InsertNoteUseCase
import com.example.workaroundproject.room.domain.usecases.InsertNoteUseCaseImpl
import com.example.workaroundproject.room.domain.usecases.ObserveListOfNotesUseCase
import com.example.workaroundproject.room.domain.usecases.ObserveListOfNotesUseCaseImpl

object NoteDependencyInjector {

    private lateinit var repository: NoteRepository

    val insertDataUseCase: InsertNoteUseCase by lazy {
        InsertNoteUseCaseImpl(repository)
    }

    val deleteNoteUseCase: DeleteNoteUseCase by lazy {
        DeleteNoteUseCaseImpl(repository)
    }

    val observeListOfNotesUseCase: ObserveListOfNotesUseCase by lazy {
        ObserveListOfNotesUseCaseImpl(repository)
    }

    fun initDependencyInjector(database: NoteDatabase) {
        repository = NoteRepositoryImpl(database.noteDatabaseDao())
    }
    //viewmodel нужны usecases им нужны репозитории а репозитория нужны базы данных а ей нужен контекст
}