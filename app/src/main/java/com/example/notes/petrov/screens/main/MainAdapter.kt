package com.example.notes.petrov.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.petrov.R
import com.example.notes.petrov.models.AppNote
import kotlinx.android.synthetic.main.note_item.view.*

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()

    class MainHolder(view:View):RecyclerView.ViewHolder(view){
        val nameNote:TextView = view.item_note_name
        val textNote:TextView = view.item_note_text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {//создание холдера в котором будут храниться все вьюшки
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {//размер листа, который будет в mainAdapter обрабатываться
       holder.textNote.text = mListNotes[position].text  //инициализация полей в холдере
       holder.nameNote.text = mListNotes[position].name  //инициализация имён в холдере
    }

    override fun getItemCount(): Int = mListNotes.size//функция, которая будет отрисовывать holder в RecyclerView



    fun setList(list: List<AppNote>){
        mListNotes = list
        notifyDataSetChanged()//обновление адаптера
    }
}