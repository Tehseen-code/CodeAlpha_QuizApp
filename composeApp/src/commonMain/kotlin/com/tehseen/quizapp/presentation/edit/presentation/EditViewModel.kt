package com.tehseen.quizapp.presentation.edit.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EditViewModel: ViewModel() {
   private val _uiState = MutableStateFlow(EditUiState())
    val uiState : StateFlow<EditUiState> = _uiState.asStateFlow()

    init {
        editCard()
    }
    fun editCard(){
        _uiState.update {
            it.copy(
                question = "This is new question?",
                answer = "yes"
            )

        }
    }

}