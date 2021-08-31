package com.example.notes.petrov.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.petrov.R
import com.example.notes.petrov.databinding.FragmentMainBinding
import com.example.notes.petrov.models.AppNote
import com.example.notes.petrov.utilits.APP_ACTIVITY


class MainFragment : Fragment() {
    
    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel:MainFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter
    private lateinit var mObserverList:Observer<List<AppNote>>//подключение отключение

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mAdapter = MainAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
           val list = it.asReversed() /*переворот списка заметок*/
           mAdapter.setList(list)
        }
        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mViewModel.allNotes.observe(this,mObserverList)
        mBinding.btnAddNote.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mViewModel.allNotes.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }
//созщдаём фунцию, чтобы её обработать, но чтобы из MainAdapter не создавать экземпляр MainFragment, создаём её в companion object
    companion object{
        fun click(note: AppNote){//передача заметки
            val bundle = Bundle()
            bundle.putSerializable("note",note)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_noteFragment,bundle)
        }
    }
}