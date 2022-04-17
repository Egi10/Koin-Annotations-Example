package com.buaja.koin_annotations_example.data.source.utils


/**
 * @created 17/04/22 09.07
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val throwable: Throwable) : ApiResult<Nothing>()
}