package com.example.emmy_ibook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.emmy_ibook.R
import com.example.emmy_ibook.databinding.FragmentSuccessScreenBinding


class SuccessScreen : Fragment() {
    private var _binding: FragmentSuccessScreenBinding? = null
    private val binding get()= _binding!!
    private lateinit var navCon: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccessScreenBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.successButton.setOnClickListener {
            navCon.navigate(R.id.action_successScreen2_to_home)
        }
    }
}