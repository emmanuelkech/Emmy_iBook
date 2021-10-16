package com.example.emmy_ibook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emmy_ibook.R
import com.example.emmy_ibook.databinding.ActivitySearchBinding
import com.example.emmy_ibook.databinding.BestReadsListBinding
import com.example.emmy_ibook.databinding.BookListSearchViewBinding
import com.example.emmy_ibook.model.BookList
import java.util.*
import kotlin.collections.ArrayList

class SearchAdapter(private val context : Context, private val bookData : ArrayList<BookList>)
    : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    var filteredBookList : ArrayList<BookList> = bookData


    class SearchViewHolder(binding: BookListSearchViewBinding) : RecyclerView.ViewHolder(binding.root){
        val bookPic : ImageView = binding.brImg
        val bookTitle : TextView = binding.brTitle
        val bookAuthor : TextView = binding.brAuthor
        val bookDes : TextView = binding.brDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val searchBinding = BookListSearchViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(searchBinding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val book = bookData[position]
        holder.bookPic.setImageResource(book.bookPic)
        holder.bookTitle.text =context.resources.getString(book.bookTitle)
        holder.bookAuthor.text =context.resources.getString(book.bookAuthor)
        holder.bookDes.text =context.resources.getString(book.bookDes)
    }

    override fun getItemCount() = bookData.size

    fun getFilter() : Filter{
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val searchText = p0.toString()
                if (searchText != null) {
                    if (searchText.isEmpty()){
                        filteredBookList = bookData
                    }else{
                        val result = ArrayList<BookList>()
                        bookData.forEach {
                            if (it.toString().toLowerCase().contains(searchText)){

                                result.add(it)
                            }
                        }
                        filteredBookList = result
                    }
                }
                val filterResults = FilterResults()
                    filterResults.values=filteredBookList
                    return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                filteredBookList = p1?.values as ArrayList<BookList>
                notifyDataSetChanged()
            }

        }
    }

}