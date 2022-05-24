package com.example.aac_paging_dddd.ui.feature.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aac_paging_dddd.data.bookModel.BookModel
import com.example.aac_paging_dddd.databinding.ItemMainBinding

class MainAdapter(
    private val context: Context
) : PagingDataAdapter<BookModel.Document, MainAdapter.MainViewHolder>(DiffUtil) {

    var datas = mutableListOf<BookModel.Document>()

    interface OnItemClickListener{
        fun onItemClick(v: View, data: BookModel.Document, pos : Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    inner class MainViewHolder constructor(
        private val binding: ItemMainBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BookModel.Document) {
            // view & data 연결
            binding.apply {
                tvId.text = item.title
                tvName.text = item.contents
            }
            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView, item, pos)
                }
            }

        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        //val currentItem = getItem(position)
        //if (currentItem != null) holder.bind(currentItem)
        getItem(position)?.let {
            holder.bind(it)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    companion object {
        private val DiffUtil = object : DiffUtil.ItemCallback<BookModel.Document>() {
            override fun areItemsTheSame(
                oldItem: BookModel.Document,
                newItem: BookModel.Document
            ): Boolean =
                oldItem.url == newItem.url


            override fun areContentsTheSame(
                oldItem: BookModel.Document,
                newItem: BookModel.Document
            ): Boolean =
                oldItem == newItem



        }
    }
}
