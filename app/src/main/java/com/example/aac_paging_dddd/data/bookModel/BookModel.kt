package com.example.aac_paging_dddd.data.bookModel


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookModel(
    @SerializedName("documents")
    val documents: List<Document>,
    @SerializedName("meta")
    val meta: Meta
) : Parcelable {
    @Parcelize
    data class Document(
        @SerializedName("authors")
        val authors: List<String>?,
        @SerializedName("contents")
        val contents: String?,
        @SerializedName("datetime")
        val datetime: String?,
        @SerializedName("isbn")
        val isbn: String?,
        @SerializedName("price")
        val price: Int?,
        @SerializedName("publisher")
        val publisher: String?,
        @SerializedName("sale_price")
        val salePrice: Int?,
        @SerializedName("status")
        val status: String?,
        @SerializedName("thumbnail")
        val thumbnail: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("translators")
        val translators: List<String>?,
        @SerializedName("url")
        val url: String?
    ): Parcelable

    @Parcelize
    data class Meta(
        @SerializedName("is_end")
        val isEnd: Boolean?,
        @SerializedName("pageable_count")
        val pageableCount: Int?,
        @SerializedName("total_count")
        val totalCount: Int?
    ) : Parcelable
}