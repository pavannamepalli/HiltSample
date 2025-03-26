package com.example.lokal.utilities

sealed class ResultClass<out T> {
    object Loading : ResultClass<Nothing>()
    data class Success<T>(val data: T) : ResultClass<T>()
    data class Error(val message: String) : ResultClass<Nothing>()
}