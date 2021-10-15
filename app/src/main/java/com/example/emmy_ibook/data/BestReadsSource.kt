package com.example.emmy_ibook.data

import com.example.emmy_ibook.R
import com.example.emmy_ibook.model.BestReads
import com.example.emmy_ibook.model.ExploreBooks

class BestReadsSource {

    fun loadBestReads() : List<BestReads>{
        return listOf(
            BestReads(R.drawable.bk1,R.string.book_title1, R.string.book_author1, R.string.book_description1),
            BestReads(R.drawable.bk2,R.string.book_title2, R.string.book_author2, R.string.book_description2),
            BestReads(R.drawable.bk3,R.string.book_title3, R.string.book_author3, R.string.book_description3)
        )
    }
}

class ExploreCategoriesSource {

    fun loadExploreCategories() : List<ExploreBooks>{
        return listOf(
            ExploreBooks(R.drawable.cat_1, R.string.title1),
            ExploreBooks(R.drawable.cat_2, R.string.title2),
            ExploreBooks(R.drawable.cat_3, R.string.title3),
            ExploreBooks(R.drawable.cat_4, R.string.title4)
        )
    }
}
