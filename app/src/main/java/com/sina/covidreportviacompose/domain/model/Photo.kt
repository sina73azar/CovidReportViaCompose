package com.sina.covidreportviacompose.domain.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Photo(
    @SerializedName("albumId")
    val albumId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?
)