package com.buaja.koin_annotations_example.data.source.remote

import com.buaja.koin_annotations_example.data.source.remote.helper.safeApiCall
import com.buaja.koin_annotations_example.data.source.remote.response.MealsResponse
import com.buaja.koin_annotations_example.data.source.remote.routes.MealService
import com.buaja.koin_annotations_example.data.source.utils.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single


/**
 * @created 11/04/22 06.44
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

@Single
class MealDataSourceImpl(
    private val mealService: MealService,
    @Named("IoDispatcher") private val coroutineDispatcher: CoroutineDispatcher
) : MealDataSource {
    override fun getFood(): Flow<ApiResult<MealsResponse>> {
        return safeApiCall(
            dispatcher = coroutineDispatcher,
            apiCall = {
                mealService.getRandomMeals()
            }
        )
    }
}