package com.example.notesappfragments.Database

import androidx.lifecycle.LiveData
import com.example.notesappfragments.Model.Note

class Repository(private val dao:NoteDao) {
    suspend fun addNote(note: Note){
        dao.addNote(note)
    }

//    val getAllNote: LiveData<List<Note>> = dao.getAllNote()

      fun  getAllNotes():LiveData<List<Note>> = dao.getAllNote()

    suspend fun updateNote(note: Note){
        dao.updateNote(note)
    }


    suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

        suspend fun deleteAllNote(){
        dao.deleteAllNote()
    }
}
