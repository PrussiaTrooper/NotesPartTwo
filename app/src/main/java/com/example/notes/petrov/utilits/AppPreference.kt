package com.example.notes.petrov.utilits

import android.content.Context
import android.content.SharedPreferences
import java.util.prefs.AbstractPreferences

object AppPreference {

    private const val INIT_USER = "initUser"
    private const val TYPE_DB = "typeDB"
    private const val NAME_PREF = "preference"

    //Объект, который позволяет сохранять настройки в приложении в виде файла во внутренней директории приложения
    private lateinit var mPreferences: SharedPreferences

    fun getPreference(context: Context):SharedPreferences{
        mPreferences = context.getSharedPreferences(NAME_PREF,Context.MODE_PRIVATE)
        return mPreferences
    }

    //Функции задающие значания
    fun setInitUser(init:Boolean){
        mPreferences.edit()
            .putBoolean(INIT_USER,init)
            .apply()
    }

    fun setTypeDB(type:String){
        mPreferences.edit()
            .putString(TYPE_DB,type)
            .apply()
    }

    fun getInitUser(): Boolean{
        return mPreferences.getBoolean(INIT_USER,false)
    }

    fun getTypeDB():String {
        return mPreferences.getString(TYPE_DB, TYPE_ROOM).toString()
    }
}