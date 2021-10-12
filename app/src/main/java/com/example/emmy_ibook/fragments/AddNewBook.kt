package com.example.emmy_ibook.fragments

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.emmy_ibook.R
import com.example.emmy_ibook.databinding.FragmentAddNewBookBinding


class add_new_book : Fragment() {
    private var _binding: FragmentAddNewBookBinding? = null
    private val binding get()= _binding!!
    private var navCon: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val themeWrapperContext = ContextThemeWrapper(this.activity, R.style.AddNewBookTheme)
        val localInflater: LayoutInflater = inflater.cloneInContext(themeWrapperContext)
        _binding = FragmentAddNewBookBinding.inflate(localInflater, container, false, )
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.addBtn.setOnClickListener {
            //add code to navigate from this fragment to the category fragment here using "navCon [already initialised]"
        }
        binding.donateHardCopyBtn.setOnClickListener {
            //add code to navigate from this fragment to the 
        }
    }


}