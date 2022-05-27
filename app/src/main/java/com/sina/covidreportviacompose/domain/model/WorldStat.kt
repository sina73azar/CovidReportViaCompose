package com.sina.covidreportviacompose.domain.model

import com.google.gson.annotations.SerializedName

data class WorldStat(
     val updated :String?=null,
     val cases :String?=null,
     val todayCases :String?=null,
     val deaths :String?=null,
     val todayDeaths :String?=null,
     val recovered :String?=null,
     val todayRecovered :String?=null,
     val active :String?=null,
     val critical :String?=null,
     val casesPerOneMillion :String?=null,
     val deathsPerOneMillion :String?=null,
     val tests :String?=null,
     val testsPerOneMillion :String?=null,
     val population :String?=null,
     val oneCasePerPeople :String?=null,
     val oneDeathPerPeople :String?=null,
     val oneTestPerPeople :String?=null,
     val activePerOneMillion :String?=null,
     val recoveredPerOneMillion :String?=null,
     val criticalPerOneMillion :String?=null,
     val affectedCountries :String?=null
)
