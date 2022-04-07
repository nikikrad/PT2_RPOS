package com.example.pt2_rpos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pt2_rpos.data.PersonDatabase
import com.example.pt2_rpos.data.PersonEntity
import com.example.pt2_rpos.databinding.FragmentResultBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding
    var personList: List<PersonEntity> = emptyList<PersonEntity>()


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


        adapter(binding)
        refreshApp(binding)
    }

    fun getAllPerson(): List<PersonEntity>{
        lifecycleScope.launch(Dispatchers.IO) {
            val database = activity?.applicationContext?.let { PersonDatabase.getDatabase(it) }
            val personDao = database?.PersonDao()
            personList = personDao?.readAllData()!!
        }
        Thread.sleep(100)
        return personList
    }

    private fun adapter(
        binding: FragmentResultBinding
    ) {
        val Adapter = activity?.applicationContext?.let { ResultAdapter(getAllPerson(), it, binding) }
        binding.rvPerson.layoutManager =
            LinearLayoutManager(
                activity?.applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        binding.rvPerson.layoutManager = linearLayoutManager
        binding.rvPerson.adapter = Adapter
    }

    fun showSnackBar(
        id: Int,
        applicationContext: Context,
        binding: FragmentResultBinding
    ) {
        Snackbar.make(
            binding.fragmentResult,
            "Вы хотите удалить этого пользователя?",
            Snackbar.LENGTH_LONG
        ).setAction("Удалить") {
            deletePerson(id, applicationContext)
            Toast.makeText(applicationContext, "Удалил успешно", Toast.LENGTH_SHORT).show()
        }.show()
    }

    private fun refreshApp(binding: FragmentResultBinding) {
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            adapter(binding)
        }
    }

    fun deletePerson(id: Int, applicationContext: Context) {
        lifecycleScope.launch(Dispatchers.IO) {
            val database = applicationContext.let { PersonDatabase.getDatabase(it) }
            val personDao = database?.PersonDao()
            personDao?.deletePerson(id)
        }
    }
}