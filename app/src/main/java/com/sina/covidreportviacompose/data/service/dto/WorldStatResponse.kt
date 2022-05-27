package com.sina.covidreportviacompose.data.service.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep


data class WorldStatResponse(
    @SerializedName("active")
    val active: Int?,
    @SerializedName("activePerOneMillion")
    val activePerOneMillion: Double?,
    @SerializedName("affectedCountries")
    val affectedCountries: Int?,
    @SerializedName("cases")
    val cases: Int?,
    @SerializedName("casesPerOneMillion")
    val casesPerOneMillion: Int?,
    @SerializedName("critical")
    val critical: Int?,
    @SerializedName("criticalPerOneMillion")
    val criticalPerOneMillion: Double?,
    @SerializedName("deaths")
    val deaths: Int?,
    @SerializedName("deathsPerOneMillion")
    val deathsPerOneMillion: Double?,
    @SerializedName("oneCasePerPeople")
    val oneCasePerPeople: Int?,
    @SerializedName("oneDeathPerPeople")
    val oneDeathPerPeople: Int?,
    @SerializedName("oneTestPerPeople")
    val oneTestPerPeople: Int?,
    @SerializedName("population")
    val population: Long?,
    @SerializedName("recovered")
    val recovered: Int?,
    @SerializedName("recoveredPerOneMillion")
    val recoveredPerOneMillion: Double?,
    @SerializedName("tests")
    val tests: Long?,
    @SerializedName("testsPerOneMillion")
    val testsPerOneMillion: Double?,
    @SerializedName("todayCases")
    val todayCases: Int?,
    @SerializedName("todayDeaths")
    val todayDeaths: Int?,
    @SerializedName("todayRecovered")
    val todayRecovered: Int?,
    @SerializedName("updated")
    val updated: Long?
)