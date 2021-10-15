package com.example.emmy_ibook.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.emmy_ibook.R
import com.example.emmy_ibook.model.NavigationItemModel
import com.example.emmy_ibook.adapter.NavigationRvAdapter
import android.widget.TextView
import android.widget.ImageView

class NavigationRvAdapter(private var items: ArrayList<NavigationItemModel>, private var currentPos: Int) :RecyclerView.Adapter<NavigationRvAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val navigationTitle: TextView = itemView.findViewById(R.id.navigation_title)
        val navigationIcon: ImageView = itemView.findViewById(R.id.navigation_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem = LayoutInflater.from(parent.context).inflate(R.layout.row_nav_drawer, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        // To highlight the selected item, show different background color
        if (position == currentPos) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.green))
            holder.navigationTitle.setTextColor(Color.WHITE)
            holder.navigationIcon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            holder.navigationTitle.setTextColor(ContextCompat.getColor(context, R.color.green))
            holder.navigationIcon.setColorFilter(ContextCompat.getColor(context, R.color.green), PorterDuff.Mode.SRC_ATOP)
        }
        holder.navigationTitle.text = items[position].title
    }

}