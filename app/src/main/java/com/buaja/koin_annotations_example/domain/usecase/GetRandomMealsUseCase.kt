package com.buaja.koin_annotations_example.domain.usecase

import com.buaja.koin_annotations_example.domain.model.Meals
import kotlinx.coroutines.flow.Flow


/**
 * @created 11/04/22 07.32
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

interface GetRandomMealsUseCase {
    operator fun invoke(): Flow<List<Meals>>
}