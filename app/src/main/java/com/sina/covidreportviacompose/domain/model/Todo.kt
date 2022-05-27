package com.sina.covidreportviacompose.domain.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Todo(
    @SerializedName("completed")
    val completed: Boolean?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?
)