package com.buaja.koin_annotations_example.ui.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.buaja.koin_annotations_example.domain.model.Meals


/**
 * @created 14/04/22 05.28
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

@Composable
fun ItemMeals(
    meals: Meals
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .size(180.dp)
                .clip(RoundedCornerShape(16.dp)),
            model = meals.strMealThumb,
            contentDescription = null,
            loading = {
                CircularProgressIndicator()
            }
        )

        Spacer(
            modifier = Modifier
                .padding(
                    top = 8.dp
                )
        )

        Text(
            text = meals.strMeal
        )
    }
}