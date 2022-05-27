package com.sina.covidreportviacompose.domain

import com.sina.covidreportviacompose.domain.model.WorldStat
import com.sina.covidreportviacompose.domain.model.Photo
import kotlinx.coroutines.flow.Flow


interface CovidRepository {

      suspend fun getAllPhotos(): List<Photo>


      suspend fun getWorldStats():WorldStat
}