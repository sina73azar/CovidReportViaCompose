package com.sina.covidreportviacompose.data.service


import com.sina.covidreportviacompose.data.service.dto.CovidWorldDto
import com.sina.covidreportviacompose.data.service.dto.WorldStatResponse
import com.sina.covidreportviacompose.domain.model.Photo
import com.sina.covidreportviacompose.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiService {

    @GET("/todo")
    suspend fun getAllTodos(): List<Todo>

    @GET("/photos")
    suspend fun getAllPhotos(): List<Photo>

    @GET("v3/covid-19/all")
    suspend fun getWorldStats(): CovidWorldDto
}