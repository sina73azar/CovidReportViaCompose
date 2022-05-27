package com.sina.covidreportviacompose.data.service.mapper

import android.util.Log
import com.google.gson.annotations.SerializedName
import com.sina.covidreportviacompose.data.service.dto.CovidWorldDto
import com.sina.covidreportviacompose.data.service.dto.WorldStatResponse
import com.sina.covidreportviacompose.domain.model.WorldStat


/*fun WorldStatResponse.toLocalWorldStat():WorldStat=
    WorldStat(
        affectedCountries,
        cases,
        casesPerOneMillion,
        critical,
        criticalPerOneMillion,
        deaths,
        deathsPerOneMillion,population,
        recovered,
        recoveredPerOneMillion,
        tests,
        testsPerOneMillion,
        todayCases,
        todayDeaths,
        todayRecovered
    )*/
fun CovidWorldDto.toWorldStat(): WorldStat {
    Log.d("mapper", "getWorldStat: $this")
    val worldStat= WorldStat(
        updated.toString(),
        cases.toString(),
        todayCases.toString(),
        deaths.toString(),
        todayDeaths.toString(),
        recovered.toString(),
        todayRecovered.toString(),
        active.toString(),
        critical.toString(),
        casesPerOneMillion.toString(),
        deathsPerOneMillion.toString(),
        tests.toString(),
        testsPerOneMillion.toString(),
        population.toString(),
        oneCasePerPeople.toString(),
        oneDeathPerPeople.toString(),
        oneTestPerPeople.toString(),
        activePerOneMillion.toString(),
        recoveredPerOneMillion.toString(),
        criticalPerOneMillion.toString(),
        affectedCountries.toString()
    )
    Log.d("mapper", "getWorldStat worldStat: $worldStat")
    return worldStat
}
