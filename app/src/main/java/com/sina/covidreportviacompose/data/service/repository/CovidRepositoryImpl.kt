package com.sina.covidreportviacompose.data.service.repository


import android.util.Log
import com.sina.covidreportviacompose.data.service.ApiService
import com.sina.covidreportviacompose.data.service.mapper.toWorldStat
import com.sina.covidreportviacompose.domain.CovidRepository
import com.sina.covidreportviacompose.domain.model.WorldStat
import com.sina.covidreportviacompose.domain.model.Photo
import com.sina.covidreportviacompose.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CovidRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CovidRepository {

    override suspend fun getAllPhotos(): List<Photo> {
        return apiService.getAllPhotos()
    }

    override suspend fun getWorldStats(): WorldStat {
        val dto=apiService.getWorldStats()
        Log.d("repo", "getWorldStats: ${dto.cases}")
        return dto.toWorldStat()

    }
}