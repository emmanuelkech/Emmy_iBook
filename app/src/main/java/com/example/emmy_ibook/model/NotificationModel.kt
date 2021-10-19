package com.example.emmy_ibook.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class NotificationModel (
    @StringRes val nameStringResourceId: Int,
    @StringRes val textStringResourceId: Int,
    @StringRes val timeStringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
        )