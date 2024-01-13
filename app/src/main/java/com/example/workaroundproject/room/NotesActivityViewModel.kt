package com.example.workaroundproject.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workaroundproject.room.di.NoteDependencyInjector
import com.example.workaroundproject.room.domain.entities.NoteItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotesActivityViewModel : ViewModel() {

    private val _noteViewStateFlow: MutableStateFlow<NoteViewState> =
        MutableStateFlow(NoteViewState(emptyList()))
    val noteViewStateFlow: StateFlow<NoteViewState> = _noteViewStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            NoteDependencyInjector.observeListOfNotesUseCase.observeListOfNotes()
                .collect { listOfNotes ->
                    _noteViewStateFlow.value = NoteViewState(listOfNotes)
                }
        }
    }

    fun insertNote(note: NoteItem) {
        viewModelScope.launch {
            NoteDependencyInjector.insertDataUseCase.insertNote(note)
        }

    }

    fun deleteNote(id: Int) {
        viewModelScope.launch {
            NoteDependencyInjector.deleteNoteUseCase.deleteNote(id)
        }
    }

}