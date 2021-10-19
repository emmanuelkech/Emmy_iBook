package com.example.emmy_ibook.activity

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emmy_ibook.adapter.SearchAdapter
import com.example.emmy_ibook.databinding.ActivitySearchBinding
import com.example.emmy_ibook.model.BookList
import kotlin.collections.ArrayList

class Search : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var adapter: SearchAdapter
    private lateinit var bookList: ArrayList<BookList>
    private lateinit var filteredBookList: ArrayList<BookList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleIntent(intent)

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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        if (Intent.ACTION_SEARCH==intent?.action){
            val query = intent.getStringExtra(SearchManager.QUERY)
        }
    }

}