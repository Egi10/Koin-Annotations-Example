package com.buaja.koin_annotations_example.domain.model

import com.buaja.koin_annotations_example.data.source.remote.response.Meal


/**
 * @created 11/04/22 07.25
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

data class Meals(
    val strMeal: String,
    val strMealThumb: String
)

fun List<Meal>.mapResponse(): List<Meals> {
    return this.map {
        Meals(
            strMeal = it.strMeal,
            strMealThumb = it.strMealThumb
        )
    }
}
