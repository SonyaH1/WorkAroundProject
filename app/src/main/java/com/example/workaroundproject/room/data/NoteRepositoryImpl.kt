package com.example.workaroundproject.room.data

import com.example.workaroundproject.room.dao.NoteDao
import com.example.workaroundproject.room.domain.entities.NoteItem
import com.example.workaroundproject.room.domain.datastore.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val noteDao: NoteDao
): NoteRepository {

    override fun observeNotes(): Flow<List<NoteItem>> {
        return noteDao.getListOfNotes().map { listOfNotes->
            listOfNotes.map {
                it.toDomainNoteItem()
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun insertNote(noteItem: NoteItem) {
       noteDao.insertNote(noteItem.toNoteItemEntity())
    }

    override suspend fun deleteNote(id: Int) {
        noteDao.deleteNote(id)
    }
}