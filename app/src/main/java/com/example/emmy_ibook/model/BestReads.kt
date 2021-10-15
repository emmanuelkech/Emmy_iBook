package com.example.emmy_ibook.model

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class BestReads(
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringResourceId: Int,
    val stringResourceId1: Int,
    val stringResourceId2: Int
)

data class ExploreBooks(
    @DrawableRes val imageResourceId1: Int,
    @StringRes val stringResourceId3: Int
)
