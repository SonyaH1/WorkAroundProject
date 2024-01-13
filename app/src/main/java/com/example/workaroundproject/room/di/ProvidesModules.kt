package com.example.workaroundproject.room.di

import android.content.Context
import androidx.room.Room
import com.example.workaroundproject.room.dao.NoteDao
import com.example.workaroundproject.room.data.NoteRepositoryImpl
import com.example.workaroundproject.room.db.NoteDatabase
import com.example.workaroundproject.room.domain.datastore.NoteRepository
import com.example.workaroundproject.room.domain.usecases.DeleteNoteUseCase
import com.example.workaroundproject.room.domain.usecases.DeleteNoteUseCaseImpl
import com.example.workaroundproject.room.domain.usecases.InsertNoteUseCase
import com.example.workaroundproject.room.domain.usecases.InsertNoteUseCaseImpl
import com.example.workaroundproject.room.domain.usecases.ObserveListOfNotesUseCase
import com.example.workaroundproject.room.domain.usecases.ObserveListOfNotesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    companion object {
        private const val DATABASE_NAME = "note_database"

        @Provides
        @Singleton
        fun provideAppDatabase(
            @ApplicationContext appContext: Context,
        ): NoteDatabase {
            return Room.databaseBuilder(
                appContext,
                NoteDatabase::class.java,
                DATABASE_NAME
            ).build()
        }


        @Provides
        @Singleton
        fun provideNoteDatabaseDao(db: NoteDatabase): NoteDao {
            return db.noteDatabaseDao()
        }

    }
}

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindsNotesRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository
}

@Module
@InstallIn(SingletonComponent::class)
interface UseCasesModule {

    @Binds
    fun bindsObserveListOfNotesUseCase(observeListOfNotesUseCaseImpl: ObserveListOfNotesUseCaseImpl): ObserveListOfNotesUseCase

    @Binds
    fun bindsInsertNoteUseCase(insertNoteUseCaseImpl: InsertNoteUseCaseImpl): InsertNoteUseCase

    @Binds
    fun bindsDeleteNoteUseCase(deleteNoteUseCaseImpl: DeleteNoteUseCaseImpl): DeleteNoteUseCase
}