package com.example.emmy_ibook.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emmy_ibook.R
import com.example.emmy_ibook.adapter.BestReadsAdapter
import com.example.emmy_ibook.adapter.SearchAdapter
import com.example.emmy_ibook.data.BestReadsSource
import com.example.emmy_ibook.data.BookListSource
import com.example.emmy_ibook.databinding.ActivityMainBinding
import com.example.emmy_ibook.databinding.ActivitySearchBinding
import com.example.emmy_ibook.model.BestReads
import com.example.emmy_ibook.model.BookList
import java.util.*
import kotlin.collections.ArrayList

class Search : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var adapter: SearchAdapter
    private lateinit var bookList: ArrayList<BookList>
    private lateinit var filteredBookList: ArrayList<BookList>
//    lateinit var bookPic: Array<Int>
//    lateinit var bookTitle: Array<Int>
//    lateinit var bookAuthor: Array<Int>
//    lateinit var bookDes: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = SearchAdapter(this, bookList)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.getFilter().filter(p0)
                return false
            }

        })

    }
}