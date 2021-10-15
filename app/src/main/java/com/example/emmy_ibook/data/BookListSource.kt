package com.example.emmy_ibook.data

import com.example.emmy_ibook.R
import com.example.emmy_ibook.model.BookList

class BookListSource {

    fun getBook(): List<BookList> {
        val books = ArrayList<BookList>()
        listOf(
            BookList(R.drawable.bk1, R.string.book_title1, R.string.book_author1, R.string.book_description1),
            BookList(R.drawable.bk2, R.string.book_title2, R.string.book_author2, R.string.book_description2),
            BookList(R.drawable.bk3, R.string.book_title3, R.string.book_author3, R.string.book_description3)
        )
        return books
    }
}