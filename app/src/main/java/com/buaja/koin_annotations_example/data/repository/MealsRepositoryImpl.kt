package com.buaja.koin_annotations_example.data.repository

import com.buaja.koin_annotations_example.data.source.remote.MealDataSource
import com.buaja.koin_annotations_example.domain.model.Meals
import com.buaja.koin_annotations_example.domain.model.mapResponse
import com.buaja.koin_annotations_example.domain.repository.MealRepository
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
    override fun getRandomMeals(): Flow<List<Meals>> {
        return mealDataSource.getFood().map {
            it.meals.mapResponse()
        }
    }
}