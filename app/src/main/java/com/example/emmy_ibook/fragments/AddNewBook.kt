package com.example.emmy_ibook.fragments

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.emmy_ibook.R
import com.example.emmy_ibook.databinding.FragmentAddNewBookBinding


class AddNewBook : Fragment() {
    private var _binding: FragmentAddNewBookBinding? = null
    private val binding get()= _binding!!
    private lateinit var navCon: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewBookBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.backArrowBtn.setOnClickListener {
            navCon.navigateUp()
        }
        binding.addBtn.setOnClickListener {
            //add code to navigate from "this fragment" to "category fragment" here using "navCon [already initialised]".
        }
        binding.donateHardCopyBtn.setOnClickListener {
            //add code to navigate from "this fragment" to the "donate a hard copy book fragment" here.
        }
    }


}