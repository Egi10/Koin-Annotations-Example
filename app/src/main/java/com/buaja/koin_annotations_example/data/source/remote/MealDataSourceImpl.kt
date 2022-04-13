package com.buaja.koin_annotations_example.data.source.remote

import com.buaja.koin_annotations_example.data.source.remote.response.MealsResponse
import com.buaja.koin_annotations_example.data.source.remote.routes.MealService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Single


/**
 * @created 11/04/22 06.44
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

@Single
class MealDataSourceImpl(
    private val mealService: MealService
) : MealDataSource {
    override fun getFood(): Flow<MealsResponse> {
        return flow {
            emit(
                mealService.getRandomMeals()
            )
        }.flowOn(Dispatchers.IO)
    }
}