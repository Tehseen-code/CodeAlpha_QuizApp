package com.tehseen.quizapp.presentation.add.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AddUiState())
    val uiState : StateFlow<AddUiState> = _uiState.asStateFlow()

    init {
        addCard()
    }

    fun addCard(){
        _uiState.update {
            it.copy(
                question = "This is new question?",
                answer = "yes"
            )

        }
    }
}