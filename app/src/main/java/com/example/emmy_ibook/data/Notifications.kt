package com.example.emmy_ibook.data

import com.example.emmy_ibook.R
import com.example.emmy_ibook.model.NotificationModel

class Notifications {
    fun loadNotificationModel() : List<NotificationModel> {

        return listOf(
            NotificationModel(R.string.user1, R.string.notification1, R.string.time1, R.drawable.reading),
            NotificationModel(R.string.user1, R.string.notification1, R.string.time1, R.drawable.reading),
            NotificationModel(R.string.user1, R.string.notification1, R.string.time1, R.drawable.reading),
            NotificationModel(R.string.user1, R.string.notification1, R.string.time1, R.drawable.reading),
            NotificationModel(R.string.user1, R.string.notification1, R.string.time1, R.drawable.reading),
            NotificationModel(R.string.user1, R.string.notification1, R.string.time1, R.drawable.reading)
        )

    }
}