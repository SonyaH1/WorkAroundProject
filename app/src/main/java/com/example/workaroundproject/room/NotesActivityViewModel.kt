package com.example.workaroundproject.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workaroundproject.room.domain.entities.NoteItem
import com.example.workaroundproject.room.domain.usecases.DeleteNoteUseCase
import com.example.workaroundproject.room.domain.usecases.InsertNoteUseCase
import com.example.workaroundproject.room.domain.usecases.ObserveListOfNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesActivityViewModel @Inject constructor(
    private val observeListOfNotesUseCase: ObserveListOfNotesUseCase,
    private val insertNoteUseCase: InsertNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    ) : ViewModel() {

    private val _noteViewStateFlow: MutableStateFlow<NoteViewState> =
        MutableStateFlow(NoteViewState(emptyList()))
    val noteViewStateFlow: StateFlow<NoteViewState> = _noteViewStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            observeListOfNotesUseCase.observeListOfNotes()
                .collect { listOfNotes ->
                    _noteViewStateFlow.value = NoteViewState(listOfNotes)
                }
        }
    }

    fun insertNote(note: NoteItem) {
        viewModelScope.launch {
            insertNoteUseCase.insertNote(note)
        }

    }

    fun deleteNote(id: Int) {
        viewModelScope.launch {
            deleteNoteUseCase.deleteNote(id)
        }
    }

}
/*
old version ->

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
 */