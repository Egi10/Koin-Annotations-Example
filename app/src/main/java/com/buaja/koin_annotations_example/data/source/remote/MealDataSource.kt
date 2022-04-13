package com.buaja.koin_annotations_example.data.source.remote

import com.buaja.koin_annotations_example.data.source.remote.response.MealsResponse
import kotlinx.coroutines.flow.Flow


/**
 * @created 11/04/22 06.39
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

interface MealDataSource {
    fun getFood(): Flow<MealsResponse>
}