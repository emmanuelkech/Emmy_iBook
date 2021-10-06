package com.example.emmy_ibook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.emmy_ibook.R
import com.example.emmy_ibook.databinding.FragmentProceedPageBinding


class ProceedPage : Fragment() {

    private var _binding: FragmentProceedPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProceedPageBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.proceedBtn.setOnClickListener {
            navCon.navigate(R.id.action_proceedPage_to_signinPage)
        }
    }
}