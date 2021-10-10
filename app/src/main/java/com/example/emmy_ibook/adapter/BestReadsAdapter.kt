package com.example.emmy_ibook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emmy_ibook.R
import com.example.emmy_ibook.fragments.HomeFragment
import com.example.emmy_ibook.model.BestReads

class BestReadsAdapter(private val context: HomeFragment, private val dataSet: List<BestReads> ) : RecyclerView.Adapter<BestReadsAdapter.BestReadsViewHolder>(){


    class BestReadsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val bookImage : ImageView = view.findViewById(R.id.br_img)
        val bookTitle : TextView = view.findViewById(R.id.br_title)
        val bookAuthor : TextView = view.findViewById(R.id.br_author)
        val bookDescription : TextView = view.findViewById(R.id.br_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestReadsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.best_reads_list, parent, false)
        return BestReadsViewHolder(adapterLayout)
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