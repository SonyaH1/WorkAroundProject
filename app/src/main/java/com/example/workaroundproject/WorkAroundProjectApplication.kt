package com.example.workaroundproject

import android.app.Application
import com.example.workaroundproject.room.db.NoteDatabase
import com.example.workaroundproject.room.di.NoteDependencyInjector

class WorkAroundProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val database = NoteDatabase.getInstance(this@WorkAroundProjectApplication)
        NoteDependencyInjector.initDependencyInjector(database)

    }
}