package com.example.pt2_rpos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.example.pt2_rpos.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {

    lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bundle = Bundle()
        val clickAnimation: Animation =
            AnimationUtils.loadAnimation(activity?.applicationContext, R.anim.anim_button)
        binding.btnEnter.setOnClickListener {
            binding.btnEnter.startAnimation(clickAnimation)
            val personName = binding.etName.text.toString()
            bundle.putString("NAME", personName)
            findNavController(view).navigate(R.id.menuFragment, bundle)
        }
    }
}