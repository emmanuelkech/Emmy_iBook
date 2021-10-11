package com.example.emmy_ibook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.emmy_ibook.databinding.FragmentCategorisationBinding

class Categorisation : Fragment() {

    private var _binding: FragmentCategorisationBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCategorisationBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnAll.setOnClickListener {

        }
    }
}


