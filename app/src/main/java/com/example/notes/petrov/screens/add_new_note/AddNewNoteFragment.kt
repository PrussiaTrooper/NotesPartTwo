package com.example.notes.petrov.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.petrov.R
import com.example.notes.petrov.databinding.FragmentAddNewNoteBinding
import com.example.notes.petrov.models.AppNote
import com.example.notes.petrov.utilits.APP_ACTIVITY
import com.example.notes.petrov.utilits.showToast


class AddNewNoteFragment : Fragment() {

    private var _binding:FragmentAddNewNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddNewNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }


    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        mBinding.btnAddNote.setOnClickListener{
            val name = mBinding.inputNameNote.text.toString()
            val text = mBinding.inputTextNote.text.toString()
            if (name.isEmpty()){
                showToast(getString(R.string.toast_enter_name))
            } else {
                mViewModel.insert(AppNote(name = name,text = text)){
         //колбэк по успешной вставки заметки
                    APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}