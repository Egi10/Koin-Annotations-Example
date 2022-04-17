package com.buaja.koin_annotations_example.data.repository

import com.buaja.koin_annotations_example.data.source.remote.MealDataSource
import com.buaja.koin_annotations_example.data.source.utils.ApiResult
import com.buaja.koin_annotations_example.domain.helper.fetchError
import com.buaja.koin_annotations_example.domain.model.Meals
import com.buaja.koin_annotations_example.domain.model.mapResponse
import com.buaja.koin_annotations_example.domain.repository.MealRepository
import com.buaja.koin_annotations_example.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single


/**
 * @created 11/04/22 07.27
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

@Single
class MealsRepositoryImpl(
    private val mealDataSource: MealDataSource
) : MealRepository {
    override fun getRandomMeals(): Flow<ResultState<List<Meals>>> {
        return mealDataSource.getFood()
            .map {
                when (it) {
                    is ApiResult.Success -> {
                        ResultState.Success(it.data.meals.mapResponse())
                    }

                    is ApiResult.Error -> {
                        /**
                         * You can return it as a string and call fetchError or you can just return
                         * Throwable and in ViewModel handleError it.
                         *
                         * ResultState.Error(it.throwable) or fetchError(it.throwable)
                         */
                        fetchError(it.throwable)
                    }
                }
            }
    }
}