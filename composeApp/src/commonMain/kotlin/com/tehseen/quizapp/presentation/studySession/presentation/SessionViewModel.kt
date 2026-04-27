package com.tehseen.quizapp.presentation.studySession.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SessionViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SessionUiState())
    val uiState : StateFlow<SessionUiState> = _uiState.asStateFlow()

    fun showDialog(){
        _uiState.update {
            it.copy(showDeleteDialog = true)
        }
    }
    fun hideDeleteDialog() {
        _uiState.update { it.copy(showDeleteDialog = false) }
    }
    fun deleteCurrentCard(){
        hideDeleteDialog()
    }
}