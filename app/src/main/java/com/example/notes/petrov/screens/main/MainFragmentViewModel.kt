package com.example.notes.petrov.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notes.petrov.utilits.REPOSITORY

class MainFragmentViewModel(application: Application):AndroidViewModel(application) {

    val allNotes = REPOSITORY.allNotes //получаем allNotes, а возвращаещает liveData
    fun signOut(){
        REPOSITORY.singOut()
    }

}