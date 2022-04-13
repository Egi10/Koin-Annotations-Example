package com.buaja.koin_annotations_example.data.source.remote.routes

import com.buaja.koin_annotations_example.data.source.remote.response.MealsResponse
import retrofit2.http.GET


/**
 * @created 11/04/22 06.59
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

interface MealService {
    @GET("random.php")
    suspend fun getRandomMeals(): MealsResponse
}