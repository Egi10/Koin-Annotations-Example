package com.buaja.koin_annotations_example.data.source.remote.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealsResponse(
    @field:Json(name = "meals")
    val meals: List<Meal>
)

@JsonClass(generateAdapter = true)
data class Meal(
    @field:Json(name = "idMeal")
    val idMeal: String,
    @field:Json(name = "strArea")
    val strArea: String,
    @field:Json(name = "strCategory")
    val strCategory: String,
    @field:Json(name = "strMeal")
    val strMeal: String,
    @field:Json(name = "strMealThumb")
    val strMealThumb: String,
)