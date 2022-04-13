package com.buaja.koin_annotations_example.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.buaja.koin_annotations_example.ui.main.components.ItemMeals
import com.buaja.koin_annotations_example.ui.theme.KoinAnnotationsExampleTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uiState = viewModel.uiState.collectAsState()

            KoinAnnotationsExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (uiState.value.loading) {
                        CircularProgressIndicator()
                    }

                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        content = {
                            items(uiState.value.list) {
                                ItemMeals(
                                    meals = it
                                )
                            }
                        }
                    )

                    if (uiState.value.messageError.isNotEmpty()) {
                        Text(
                            text = uiState.value.messageError
                        )
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getMealsRandom()
    }
}