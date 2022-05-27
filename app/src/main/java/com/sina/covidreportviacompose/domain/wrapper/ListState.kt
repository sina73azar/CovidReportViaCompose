package com.sina.covidreportviacompose.domain.wrapper

sealed class ListState<out R> {

    data class Fetched<out T>(val data: T) : ListState<T>()
    data class Error(val exception: Exception) : ListState<Nothing>()
    object Empty : ListState<Nothing>()
    object Loading : ListState<Nothing>()

/*    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }*/
}