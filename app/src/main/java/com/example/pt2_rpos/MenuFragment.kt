package com.example.pt2_rpos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.example.pt2_rpos.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = arguments?.getString("NAME")
        if (name == null){
            binding.tvPersonName.text = "User"
        }else binding.tvPersonName.text = name
        val bundle = Bundle()
        bundle.putString("PersonName", name)
        binding.btnQuestion.setOnClickListener {
            findNavController(view).navigate(R.id.questionFragment, bundle)
        }
        binding.btnProfile.setOnClickListener {
            findNavController(view).navigate(R.id.profileFragment)
        }
        binding.btnResults.setOnClickListener {
            findNavController(view).navigate(R.id.resultFragment)
        }
    }

}