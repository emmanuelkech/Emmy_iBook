package com.example.emmy_ibook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emmy_ibook.R
import com.example.emmy_ibook.fragments.HomeFragment
import com.example.emmy_ibook.model.ExploreBooks

class ExploreCategoriesAdapter(private val context: HomeFragment, private val dataSet: List<ExploreBooks> ) : RecyclerView.Adapter<ExploreCategoriesAdapter.ExploreCategoriesViewHolder>() {

    class ExploreCategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val bkImage : ImageView = view.findViewById(R.id.bk_img)
        val bkDescription : TextView = view.findViewById(R.id.bk_description)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExploreCategoriesViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.explore_categories_list, parent, false)
        return ExploreCategoriesViewHolder(adapterLayout)
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