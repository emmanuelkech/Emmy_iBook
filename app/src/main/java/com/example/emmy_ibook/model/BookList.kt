package com.example.emmy_ibook.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BookList(
    @DrawableRes val bookPic: Int,
    @StringRes val bookTitle: Int,
    @StringRes val bookAuthor: Int,
    @StringRes val bookDes: Int
)
