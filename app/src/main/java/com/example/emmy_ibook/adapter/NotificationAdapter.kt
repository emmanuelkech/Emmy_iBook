package com.example.emmy_ibook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emmy_ibook.R
import com.example.emmy_ibook.model.NotificationModel


class NotificationAdapter(private val context: RecyclerView, private val dataSet: List<NotificationModel>) :
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    class NotificationViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val profilePicture : ImageView = view.findViewById(R.id.notification_dp)
        val notificationText : TextView = view.findViewById(R.id.notification_text)
        val notificationTime : TextView = view.findViewById(R.id.notification_time)
        val userName : TextView = view.findViewById(R.id.username)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.notification_row, parent, false)
        return NotificationViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notify = dataSet[position]
        holder.profilePicture.setImageResource(notify.imageResourceId)
        holder.notificationText.text = context.resources.getString(notify.textStringResourceId)
        holder.notificationTime.text = context.resources.getString(notify.timeStringResourceId)
        holder.userName.text = context.resources.getString(notify.nameStringResourceId)
    }

    override fun getItemCount() = dataSet.size

}