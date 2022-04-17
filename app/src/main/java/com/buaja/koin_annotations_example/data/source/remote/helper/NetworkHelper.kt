package com.buaja.koin_annotations_example.data.source.remote.helper

import com.buaja.koin_annotations_example.data.source.utils.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


/**
 * @created 17/04/22 09.11
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Flow<ApiResult<T>> {
    return flow<ApiResult<T>> {
        emit(ApiResult.Success(apiCall.invoke()))
    }.catch { throwable ->
        emit(ApiResult.Error(throwable))
    }.flowOn(dispatcher)
}