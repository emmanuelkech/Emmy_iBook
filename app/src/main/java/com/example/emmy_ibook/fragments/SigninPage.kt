package com.example.emmy_ibook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.emmy_ibook.R
import com.example.emmy_ibook.databinding.FragmentSigninPageBinding


class SigninPage : Fragment() {

    private var _binding: FragmentSigninPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSigninPageBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.setupAccount.setOnClickListener {
            navCon.navigate(R.id.action_signinPage_to_signupPage)
        }
    }
}