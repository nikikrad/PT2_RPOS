package com.example.pt2_rpos

import android.app.Person
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.pt2_rpos.data.PersonDatabase
import com.example.pt2_rpos.data.PersonEntity
import com.example.pt2_rpos.databinding.FragmentQuestionBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionFragment: Fragment() {

    lateinit var binding: FragmentQuestionBinding
    var status: MutableList<Int> = emptyList<Int>().toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rgFirst.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_FirstFalse -> 1
                else -> {0}
            })
        }
        binding.rgSecond.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_SecondTrue -> 1
                else -> {0}
            })
        }
        binding.rgThread.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_TreadFalse -> 1
                else -> {0}
            })
        }
        binding.rgFours.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_FoursTrue -> 1
                else -> {0}
            })
        }
        binding.rgFives.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_FivesFalse -> 1
                else -> {0}
            })
        }
        binding.rgSix.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_SixTrue -> 1
                else -> {0}
            })
        }
        binding.rgSeven.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_SevenFalse -> 1
                else -> {0}
            })
        }
        binding.rgEight.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_EightTrue -> 1
                else -> {0}
            })
        }
        binding.rgNine.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_NineFalse -> 1
                else -> {0}
            })
        }
        binding.rgTen.setOnCheckedChangeListener { group, checkedId ->
            status.add(when(checkedId){
                R.id.rb_TenFalse -> 1
                else -> {0}
            })
        }
        binding.btnEnter.setOnClickListener {
            var temp = 0;
            status.forEach {
                if(it == 1) temp ++
            }
            val name = arguments?.getString("PersonName")
            val person = PersonEntity()
            lifecycleScope.launch(Dispatchers.IO){
                val database = activity?.applicationContext?.let { PersonDatabase.getDatabase(it) }
                val personDao = database?.PersonDao()
                person.id = 0
                if (name != null) {
                    person.name = name
                }
                person.result = temp
                personDao?.addPerson(person)

                Log.e("KEK", person.name + person.result)
            }
            Navigation.findNavController(view).navigate(R.id.menuFragment)


        }

    }
}