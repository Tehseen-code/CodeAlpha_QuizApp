package com.tehseen.quizapp.presentation.edit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tehseen.quizapp.data.local.FlashcardEntity
import com.tehseen.quizapp.data.local.QuizDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EditViewModel(
    private val dao: QuizDao,
    private val cardId: Long
) : ViewModel() {

    private val _uiState = MutableStateFlow(EditUiState())
    val uiState: StateFlow<EditUiState> = _uiState.asStateFlow()

    private var originalCard: FlashcardEntity? = null

    init {
        loadCardData()
    }

    private fun loadCardData() {
        viewModelScope.launch {
            // DAO ka naya function use kar rahe hain jo seedha ID se card laye
            val card = dao.getFlashCardById(cardId)

            card?.let {
                originalCard = it
                _uiState.update { state ->
                    state.copy(
                        question = it.question,
                        answer = it.answer
                    )
                }
            }
        }
    }

    fun onQuestionChange(newQuestion: String) {
        _uiState.update { it.copy(question = newQuestion) }
    }

    fun onAnswerChange(newAnswer: String) {
        _uiState.update { it.copy(answer = newAnswer) }
    }

    fun updateCard(onComplete: () -> Unit) {
        viewModelScope.launch {
            originalCard?.let {
                val updatedEntity = it.copy(
                    question = _uiState.value.question,
                    answer = _uiState.value.answer
                )

                //ye real database mein save karega
                dao.updateFlashCard(updatedEntity)

                // UI thread par wapas navigate karne ke liye
                onComplete()
            }
        }
    }
}