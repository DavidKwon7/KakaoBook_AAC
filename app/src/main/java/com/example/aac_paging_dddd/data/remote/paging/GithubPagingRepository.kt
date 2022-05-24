package com.example.aac_paging_dddd.data.remote.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.example.aac_paging_dddd.data.bookModel.BookModel
import com.example.aac_paging_dddd.data.model.User
import io.reactivex.Flowable

interface GithubPagingRepository {

    fun getRemoteUser(query: String): Flowable<PagingData<BookModel.Document>>


}