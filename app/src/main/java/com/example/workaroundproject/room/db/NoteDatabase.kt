package com.example.workaroundproject.room.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workaroundproject.room.dao.NoteDao

@Database(
    entities = [
        NoteItemEntity::class
    ],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDatabaseDao() : NoteDao
}

/*
old version ->
    companion object{
        private const val DATABASE_NAME = "note_database"

        @Volatile
        private var instance: NoteDatabase? = null

        @Synchronized
        @JvmStatic
        fun getInstance(context: Context): NoteDatabase {
            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    DATABASE_NAME
                ).build()
                instance
            }
            return instance as NoteDatabase
        }
    }

    abstract fun noteDatabaseDao() : NoteDao
 */