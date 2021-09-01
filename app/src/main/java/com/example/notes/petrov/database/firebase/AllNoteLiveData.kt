package com.example.notes.petrov.database.firebase

import androidx.lifecycle.LiveData
import com.example.notes.petrov.models.AppNote
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllNoteLiveData: LiveData<List<AppNote>> () {
    private val mAuth = FirebaseAuth.getInstance()
    private val mDataBaseReference = FirebaseDatabase.getInstance().reference
        .child(mAuth.currentUser?.uid.toString())
    private val listener = object: ValueEventListener{
        override fun onDataChange(p0: DataSnapshot) {
            value = p0.children.map{
                it.getValue(AppNote::class.java)?: AppNote()
            }
        }

        override fun onCancelled(error: DatabaseError) {
        }
    }

    override fun onActive() {
        mDataBaseReference.addValueEventListener(listener)
        super.onActive()
    }

    override fun onInactive() {
        mDataBaseReference.removeEventListener(listener)
        super.onInactive()
    }
}