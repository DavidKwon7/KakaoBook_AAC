package com.example.aac_paging_dddd.data.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("items") val items: List<User>
    )
