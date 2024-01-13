package com.example.workaroundproject.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workaroundproject.room.db.NoteItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao  {

    @Query(
        """
            SELECT *
            FROM ${NoteItemEntity.TABLE_NAME}
        """
    )
    fun getListOfNotes() : Flow<List<NoteItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteItemEntity: NoteItemEntity)

    @Query(
        """
            DELETE
            FROM ${NoteItemEntity.TABLE_NAME}
            WHERE ${NoteItemEntity.ID} = :id
        """
    )
    suspend fun deleteNote(id: Int)
}