package com.example.aac_paging_dddd.data.remote

import com.example.aac_paging_dddd.data.bookModel.BookModel
import com.example.aac_paging_dddd.data.bookModel.Document
import com.example.aac_paging_dddd.data.model.User
import com.example.aac_paging_dddd.data.model.Users
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @Headers("Authorization: KakaoAK 97697dc90ecde1049fdadc3f1399d1c1")
    @GET("/v3/search/book")
    fun getRepos(
        @Query("query") query: String
    ) : Single<BookModel>

}