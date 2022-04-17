package com.buaja.koin_annotations_example.domain.repository

import com.buaja.koin_annotations_example.domain.model.Meals
import com.buaja.koin_annotations_example.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow


/**
 * @created 11/04/22 07.26
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

interface MealRepository {
    fun getRandomMeals(): Flow<ResultState<List<Meals>>>
}