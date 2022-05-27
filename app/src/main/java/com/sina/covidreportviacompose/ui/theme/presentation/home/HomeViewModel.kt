package com.sina.covidreportviacompose.ui.theme.presentation.home

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.sina.covidreportviacompose.domain.CovidRepository
import com.sina.covidreportviacompose.domain.model.WorldStat
import com.sina.covidreportviacompose.domain.wrapper.ListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val covidRepository: CovidRepository,
) : ViewModel() {

    var names: MutableState<ListState<List<String>>> = mutableStateOf(ListState.Empty)
    var state by mutableStateOf(WorldStatState(isLoading = true))
    var name by mutableStateOf("")
    val isRefreshing by mutableStateOf(false)
    fun getWorldStat() {
        viewModelScope.launch {
            state = state.copy(worldStat = null, error = null, isLoading = true)
//            delay(2000L)
            try {
                val data = covidRepository.getWorldStats()
                Log.d(TAG, "data: cases in model${data.cases}")
                state = state.copy(worldStat = data, error = null, isLoading = false)
            } catch (e: Exception) {

            }


        }
    }

    fun removeSpaces(text: String): String {
        return text.replace(" ", "")

    }

    fun refresh() {
        getWorldStat()
    }


}