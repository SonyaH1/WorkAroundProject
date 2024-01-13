package com.example.workaroundproject

import android.app.Application
import com.example.workaroundproject.room.db.NoteDatabase
import com.example.workaroundproject.room.di.NoteDependencyInjector
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WorkAroundProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()


    }
}
/*
old version ->
 val database = NoteDatabase.getInstance(this@WorkAroundProjectApplication)
 NoteDependencyInjector.initDependencyInjector(database)
 */