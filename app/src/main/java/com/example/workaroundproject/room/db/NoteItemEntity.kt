package com.example.workaroundproject.room.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = NoteItemEntity.TABLE_NAME)
data class NoteItemEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = ID) val id: Int? = null,
    @ColumnInfo(name = NAME) val name: String,
    @ColumnInfo(name = DESCRIPTION) val description: String,
) {

    companion object {
        const val TABLE_NAME = "noteTable"
        const val ID = "id"
        const val NAME = "name"
        const val DESCRIPTION = "description"
    }
}