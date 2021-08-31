package com.example.notes.petrov.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.notes.petrov.database.room.AppRoomDatabase
import com.example.notes.petrov.database.room.AppRoomRepository
import com.example.notes.petrov.utilits.REPOSITORY
import com.example.notes.petrov.utilits.TYPE_ROOM

class StartFragmentViewModel(application: Application):AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type:String,onSuccess:()->Unit){
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}