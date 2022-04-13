package com.buaja.koin_annotations_example.domain.usecase

import com.buaja.koin_annotations_example.domain.model.Meals
import com.buaja.koin_annotations_example.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory


/**
 * @created 11/04/22 07.33
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

@Factory
class GetRandomMealsUseCaseImpl(
    private val mealRepository: MealRepository
) : GetRandomMealsUseCase {
    override fun invoke(): Flow<List<Meals>> {
        return mealRepository.getRandomMeals()
    }
}