package com.buaja.koin_annotations_example.ui.main.state

import com.buaja.koin_annotations_example.domain.model.Meals


/**
 * @created 11/04/22 07.35
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

data class MainUiState(
    val loading: Boolean = false,
    val list: List<Meals> = emptyList(),
    val messageError: String = ""
)
