package com.example.aac_paging_dddd.data.remote.paging

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.example.aac_paging_dddd.data.bookModel.BookModel
import com.example.aac_paging_dddd.data.bookModel.Document
import com.example.aac_paging_dddd.data.model.User
import com.example.aac_paging_dddd.data.model.Users
import com.example.aac_paging_dddd.data.remote.GithubService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GithubPagingSource(
    private val service: GithubService,
    private val query: String
) : RxPagingSource<Int, BookModel.Document>() {


    /*override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, User>> {
        val position = params.key ?: 1
        return service.getRepos(owner)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it, position) }

    }

    private fun toLoadResult(data: Users, position: Int): LoadResult<Int, User> {
        return LoadResult.Page(
            data = data.items,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (listOf(data).isEmpty()) null else position + 1
        )
    }*/
    override fun getRefreshKey(state: PagingState<Int, BookModel.Document>): Int? {
        return state.anchorPosition
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, BookModel.Document>> {
        val position = params.key ?: 1
        return service.getRepos(query)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it, position) }
            .onErrorReturn { LoadResult.Error(it) }

    }

    private fun toLoadResult(data: BookModel, position: Int): LoadResult<Int, BookModel.Document> {
        return LoadResult.Page(
            data = data.documents,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (listOf(data).isEmpty()) null else position + 1
        )
    }


}