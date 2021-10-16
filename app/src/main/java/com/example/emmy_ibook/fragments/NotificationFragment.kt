package com.example.emmy_ibook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emmy_ibook.R
import com.example.emmy_ibook.adapter.NotificationAdapter
import com.example.emmy_ibook.data.Notifications
import com.example.emmy_ibook.databinding.FragmentNotificationBinding
import kotlinx.android.synthetic.main.fragment_notification.*


class NotificationFragment : Fragment() {

    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationRV.apply {
            layoutManager = LinearLayoutManager(context)
            val DataSet = Notifications().loadNotificationModel()
            adapter = NotificationAdapter(this, DataSet)

            notificationRV.addItemDecoration(
                DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
            )
        }
    }

}


