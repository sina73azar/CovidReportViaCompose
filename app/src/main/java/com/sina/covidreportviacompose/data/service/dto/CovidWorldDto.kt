package com.sina.covidreportviacompose.data.service.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

data class CovidWorldDto(
    @SerializedName("updated") val updated : Long,
    @SerializedName("cases") val cases : Long,
    @SerializedName("todayCases") val todayCases : Long,
    @SerializedName("deaths") val deaths : Long,
    @SerializedName("todayDeaths") val todayDeaths : Long,
    @SerializedName("recovered") val recovered : Long,
    @SerializedName("todayRecovered") val todayRecovered : Long,
    @SerializedName("active") val active : Long,
    @SerializedName("critical") val critical : Long,
    @SerializedName("casesPerOneMillion") val casesPerOneMillion : Long,
    @SerializedName("deathsPerOneMillion") val deathsPerOneMillion : Double,
    @SerializedName("tests") val tests : Long,
    @SerializedName("testsPerOneMillion") val testsPerOneMillion : Double,
    @SerializedName("population") val population : Long,
    @SerializedName("oneCasePerPeople") val oneCasePerPeople : Long,
    @SerializedName("oneDeathPerPeople") val oneDeathPerPeople : Long,
    @SerializedName("oneTestPerPeople") val oneTestPerPeople : Long,
    @SerializedName("activePerOneMillion") val activePerOneMillion : Double,
    @SerializedName("recoveredPerOneMillion") val recoveredPerOneMillion : Double,
    @SerializedName("criticalPerOneMillion") val criticalPerOneMillion : Double,
    @SerializedName("affectedCountries") val affectedCountries : Long
)