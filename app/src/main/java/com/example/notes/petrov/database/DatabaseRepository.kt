package com.example.notes.petrov.database

import androidx.lifecycle.LiveData
import com.example.notes.petrov.models.AppNote
//если пустые реализации убрать({}), то необходимо будет в AppRoomRepo реализовать эти функции
interface DatabaseRepository {
    val allNotes:LiveData<List<AppNote>>
    suspend fun insert(note: AppNote,onSuccess:()->Unit)
    suspend fun delete(note: AppNote,onSuccess:()->Unit)

    fun connectToDatabase(onSuccess: () -> Unit,onFail: (String) -> Unit) {}

    fun singOut() {}
}