package com.example.aac_paging_dddd

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.aac_paging_dddd.data.bookModel.BookModel
import com.example.aac_paging_dddd.databinding.ActivityMainBinding
import com.example.aac_paging_dddd.ui.feature.detail.DetailActivity
import com.example.aac_paging_dddd.ui.feature.detail.DetailViewModel
import com.example.aac_paging_dddd.ui.feature.main.MainAdapter
import com.example.aac_paging_dddd.ui.feature.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    private val viewModel by viewModels<MainViewModel>()
    private val sharedViewModel : DetailViewModel by viewModels<DetailViewModel>()
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MainAdapter(this)
        binding.recyclerView.adapter = adapter

        compositeDisposable.add(viewModel.getRemoteUser()
            .subscribe {
            adapter.submitData(lifecycle, it)
        })

        adapter.setOnItemClickListener(object : MainAdapter.OnItemClickListener {
            override fun onItemClick(v: View, data: BookModel.Document, pos: Int) {
                Intent(this@MainActivity, DetailActivity::class.java)
                    .apply {
                        putExtra(PRESENTATION_DATA, data)
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }.run { startActivity(this) }
            }

        })

    }

    override fun onDestroy() {
        mBinding = null
        compositeDisposable.clear()
        super.onDestroy()
    }

    companion object {
        const val PRESENTATION_DATA = "presentationData"
    }
}