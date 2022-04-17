package com.buaja.koin_annotations_example.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buaja.koin_annotations_example.domain.usecase.GetRandomMealsUseCase
import com.buaja.koin_annotations_example.domain.utils.ResultState
import com.buaja.koin_annotations_example.ui.main.state.MainUiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel


/**
 * @created 11/04/22 07.34
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

@KoinViewModel
class MainViewModel(
    private val getRandomMealsUseCase: GetRandomMealsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> get() = _uiState

    fun getMealsRandom() {
        viewModelScope.launch {
            getRandomMealsUseCase.invoke()
                .onStart {
                    _uiState.update {
                        it.copy(
                            loading = true
                        )
                    }
                }
                .onCompletion {
                    _uiState.update {
                        it.copy(
                            loading = false
                        )
                    }
                }
                .collect { resultState ->
                    when (resultState) {
                        is ResultState.Success -> {
                            _uiState.update {
                                it.copy(
                                    list = resultState.data
                                )
                            }
                        }

                        is ResultState.Error -> {
                            _uiState.update {
                                it.copy(
                                    messageError = resultState.message
                                )
                            }
                        }
                    }
                }
        }
    }
}