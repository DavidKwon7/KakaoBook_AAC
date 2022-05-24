package com.example.aac_paging_dddd.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PresentationModel(
    var id: String,
    var name: String,
    var favorite: Boolean = false
) : Parcelable
