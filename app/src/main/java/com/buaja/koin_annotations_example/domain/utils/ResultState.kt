package com.buaja.koin_annotations_example.domain.utils


/**
 * @created 17/04/22 08.51
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

sealed class ResultState<out T> {
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val message: String) : ResultState<Nothing>()
}