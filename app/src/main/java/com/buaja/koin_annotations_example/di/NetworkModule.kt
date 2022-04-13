package com.buaja.koin_annotations_example.di

import com.buaja.koin_annotations_example.data.source.remote.routes.MealService
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * @created 11/04/22 06.54
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

@Module
class NetworkModule {
    @Single
    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Single
    fun mealService(retrofit: Retrofit): MealService {
        return retrofit.create(MealService::class.java)
    }
}