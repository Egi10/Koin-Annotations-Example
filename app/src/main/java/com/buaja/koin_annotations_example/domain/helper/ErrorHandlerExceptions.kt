package com.buaja.koin_annotations_example.domain.helper

import com.buaja.koin_annotations_example.domain.utils.ResultState
import retrofit2.HttpException


/**
 * @created 17/04/22 09.25
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

fun fetchError(throwable: Throwable): ResultState.Error {
    return when (throwable) {
        is HttpException -> {
            when (throwable.code()) {
                404 -> {
                    ResultState.Error("Double Check Your Request, We Can't Find Data")
                }

                else -> {
                    ResultState.Error(throwable.message())
                }
            }
        }

        else -> {
            ResultState.Error(throwable.message ?: "")
        }
    }
}