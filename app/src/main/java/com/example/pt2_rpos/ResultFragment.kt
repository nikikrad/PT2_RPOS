package com.example.pt2_rpos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pt2_rpos.data.PersonDatabase
import com.example.pt2_rpos.data.PersonEntity
import com.example.pt2_rpos.databinding.FragmentResultBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultFragment: Fragment() {

    lateinit var binding: FragmentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var personList: List<PersonEntity> = emptyList<PersonEntity>()

        lifecycleScope.launch(Dispatchers.IO){
            val database = activity?.applicationContext?.let { PersonDatabase.getDatabase(it) }
            val personDao = database?.PersonDao()
            personList = personDao?.readAllData()!!
        }
        Thread.sleep(200)
        val Adapter = ResultAdapter(personList)
        binding.rvPerson.layoutManager =
            LinearLayoutManager(
                activity?.applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        binding.rvPerson.adapter = Adapter



    }
}