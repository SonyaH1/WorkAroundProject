package com.example.workaroundproject.room.data

import com.example.workaroundproject.room.db.NoteItemEntity
import com.example.workaroundproject.room.domain.entities.NoteItem

internal fun NoteItemEntity.toDomainNoteItem(): NoteItem {
    return NoteItem(
        id = id!!,
        name = name,
        description = description
    )
}

internal fun NoteItem.toNoteItemEntity(): NoteItemEntity {
    return NoteItemEntity(
        name = name,
        description = description
    )
}