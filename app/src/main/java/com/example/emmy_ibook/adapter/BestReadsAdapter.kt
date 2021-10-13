package com.example.emmy_ibook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emmy_ibook.databinding.BestReadsListBinding
import com.example.emmy_ibook.fragments.HomeFragment
import com.example.emmy_ibook.model.BestReads

class BestReadsAdapter(private val context: HomeFragment, private val dataSet: List<BestReads> )
    : RecyclerView.Adapter<BestReadsAdapter.BestReadsViewHolder>(){

    class BestReadsViewHolder(binding: BestReadsListBinding) : RecyclerView.ViewHolder(binding.root){
        val bookImage : ImageView = binding.brImg
        val bookTitle : TextView = binding.brTitle
        val bookAuthor : TextView = binding.brAuthor
        val bookDescription : TextView = binding.brDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestReadsViewHolder {
        val binding = BestReadsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BestReadsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BestReadsViewHolder, position: Int) {
        val books =dataSet[position]
        holder.bookImage.setImageResource(books.imageResourceId)
        holder.bookTitle.text =context.resources.getString(books.stringResourceId)
        holder.bookAuthor.text =context.resources.getString(books.stringResourceId1)
        holder.bookDescription.text =context.resources.getString(books.stringResourceId2)
    }

    override fun getItemCount() = dataSet.size
}