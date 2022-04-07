package com.example.pt2_rpos

import android.app.Person
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
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
        binding.btnEnter.setOnClickListener {

            var temp = 0

            val checkedRadioButtonFirst = binding.rgFirst.checkedRadioButtonId
            when(checkedRadioButtonFirst){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonFirst)
                    if(selectedRadioButton == binding.rbFirstFalse)  temp ++
                }
            }
            val checkedRadioButtonSecond = binding.rgSecond.checkedRadioButtonId
            when(checkedRadioButtonSecond){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonSecond)
                    if(selectedRadioButton == binding.rbSecondTrue)  temp ++
                }
            }
            val checkedRadioButtonThird = binding.rgThread.checkedRadioButtonId
            when(checkedRadioButtonThird){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonThird)
                    if(selectedRadioButton == binding.rbTreadFalse)  temp ++
                }
            }
            val checkedRadioButtonFours = binding.rgFours.checkedRadioButtonId
            when(checkedRadioButtonFours){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonFours)
                    if(selectedRadioButton == binding.rbFoursTrue)  temp ++
                }
            }
            val checkedRadioButtonFives = binding.rgFives.checkedRadioButtonId
            when(checkedRadioButtonFives){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonFives)
                    if(selectedRadioButton == binding.rbFivesFalse)  temp ++
                }
            }
            val checkedRadioButtonSix = binding.rgSix.checkedRadioButtonId
            when(checkedRadioButtonSix){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonSix)
                    if(selectedRadioButton == binding.rbSixTrue)  temp ++
                }
            }
            val checkedRadioButtonSeven = binding.rgSeven.checkedRadioButtonId
            when(checkedRadioButtonSeven){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonSeven)
                    if(selectedRadioButton == binding.rbSevenFalse)  temp ++
                }
            }
            val checkedRadioButtonEight = binding.rgEight.checkedRadioButtonId
            when(checkedRadioButtonEight){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonEight)
                    if(selectedRadioButton == binding.rbEightTrue)  temp ++
                }
            }
            val checkedRadioButtonNine = binding.rgNine.checkedRadioButtonId
            when(checkedRadioButtonNine){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonNine)
                    if(selectedRadioButton == binding.rbNineFalse)  temp ++
                }
            }

            val checkedRadioButtonTen = binding.rgTen.checkedRadioButtonId
            when(checkedRadioButtonTen){
                -1 -> {

                }
                else -> {
                    val selectedRadioButton = view.findViewById<RadioButton>(checkedRadioButtonTen)
                    if(selectedRadioButton == binding.rbTenFalse)  temp ++
                }
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
            }
            Toast.makeText(activity?.applicationContext, "Ваш результат " + temp.toString() + "/10", Toast.LENGTH_LONG).show()
            Navigation.findNavController(view).navigate(R.id.menuFragment)


        }

    }
}