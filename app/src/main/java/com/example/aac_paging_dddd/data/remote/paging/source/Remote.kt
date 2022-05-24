package com.example.aac_paging_dddd.data.remote.paging.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.rxjava2.flowable
import com.example.aac_paging_dddd.data.remote.GithubService
import com.example.aac_paging_dddd.data.remote.paging.GithubPagingSource
import javax.inject.Inject

class Remote @Inject constructor(
    private val service: GithubService
) {
    fun getRemoteUser(owner: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {GithubPagingSource(service, owner)}
        ).flowable
}