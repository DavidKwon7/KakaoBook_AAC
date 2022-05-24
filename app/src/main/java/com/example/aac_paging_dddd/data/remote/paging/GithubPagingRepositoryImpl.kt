package com.example.aac_paging_dddd.data.remote.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.example.aac_paging_dddd.data.bookModel.BookModel
import com.example.aac_paging_dddd.data.model.User
import com.example.aac_paging_dddd.data.remote.paging.source.Remote
import io.reactivex.Flowable
import javax.inject.Inject

class GithubPagingRepositoryImpl @Inject constructor(
    private val remote: Remote
) : GithubPagingRepository {
    override fun getRemoteUser(query: String): Flowable<PagingData<BookModel.Document>> {
        return remote.getRemoteUser(query)
    }

}