package com.example.emmy_ibook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emmy_ibook.data.BestReadsSource
import com.example.emmy_ibook.data.ExploreCategoriesSource
import com.example.emmy_ibook.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataSet = BestReadsSource().loadBestReads()
        binding.rvBestReads.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvBestReads.adapter = com.example.emmy_ibook.adapter.BestReadsAdapter(this, myDataSet)

        val myDataSet1 = ExploreCategoriesSource().loadExploreCategories()
        binding.rvExploreCategories.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.rvExploreCategories.adapter = com.example.emmy_ibook.adapter.ExploreCategoriesAdapter(this, myDataSet1)
   }
}