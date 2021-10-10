package com.example.emmy_ibook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emmy_ibook.databinding.ExploreCategoriesListBinding
import com.example.emmy_ibook.fragments.HomeFragment
import com.example.emmy_ibook.model.ExploreBooks

class ExploreCategoriesAdapter(private val context: HomeFragment, private val dataSet: List<ExploreBooks> )
    : RecyclerView.Adapter<ExploreCategoriesAdapter.ExploreCategoriesViewHolder>() {

    class ExploreCategoriesViewHolder(binding: ExploreCategoriesListBinding) : RecyclerView.ViewHolder(binding.root){
        val bkImage : ImageView = binding.bkImg
        val bkDescription : TextView = binding.bkDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreCategoriesViewHolder {
        val binding = ExploreCategoriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploreCategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ExploreCategoriesViewHolder,
        position: Int
    ) {
        val books =dataSet[position]
        holder.bkImage.setImageResource(books.imageResourceId1)
        holder.bkDescription.text =context.resources.getString(books.stringResourceId3)
    }

    override fun getItemCount() = dataSet.size
}