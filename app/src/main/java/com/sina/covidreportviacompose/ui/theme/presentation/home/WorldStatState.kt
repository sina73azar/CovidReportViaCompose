package com.sina.covidreportviacompose.ui.theme.presentation.home

import com.sina.covidreportviacompose.domain.model.WorldStat

data class WorldStatState(
    val worldStat: WorldStat?=null,
    val error:String?=null,
    val isLoading:Boolean?=false
)
