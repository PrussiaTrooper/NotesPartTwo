package com.example.notes.petrov.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.petrov.models.AppNote
import com.example.notes.petrov.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddNewNoteViewModel(application: Application): AndroidViewModel(application) {
    //метод вставляющий заметку
    fun insert(note:AppNote,onSuccess:()->Unit) =
    /*корунтина для работы в режиме лайвсайкл*/
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.insert(note){
                onSuccess()
            }
        }
}