package com.example.aac_paging_dddd.ui.feature.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.aac_paging_dddd.MainActivity
import com.example.aac_paging_dddd.R
import com.example.aac_paging_dddd.data.bookModel.BookModel
import com.example.aac_paging_dddd.data.model.PresentationModel
import com.example.aac_paging_dddd.databinding.ActivityDetailBinding
import com.example.aac_paging_dddd.ui.feature.main.MainViewModel

class DetailActivity : AppCompatActivity()
 {
     private var presentationModel: PresentationModel ?= null
     private val viewModel by viewModels<DetailViewModel>()


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val binding :ActivityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail)


        val id = findViewById<TextView>(R.id.tv_id)
        val name = findViewById<TextView>(R.id.tv_content)
        val image = findViewById<ImageView>(R.id.iv_favorite)

        val data = intent.getParcelableExtra<BookModel.Document>(MainActivity.PRESENTATION_DATA)
        id.text = data?.title
        name.text = data?.contents


        image.setOnClickListener {
            image.setImageResource(R.drawable.favorite_24)
            Toast.makeText(this, "좋아요!!", Toast.LENGTH_SHORT).show()

           // todo MainActivity와 반응 연동
            viewModel.setLiveData()
            val a = viewModel.isFavorite.value
        }


    }

}