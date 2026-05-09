package com.tehseen.quizapp.presentation.add.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tehseen.quizapp.data.local.FlashcardEntity
import com.tehseen.quizapp.data.local.QuizDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddViewModel(
    private val dao: QuizDao,
    private val deckId: Long
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddUiState())
    val uiState: StateFlow<AddUiState> = _uiState.asStateFlow()

    fun onQuestionChange(value: String) {
        _uiState.update { it.copy(question = value) }
    }

    fun onAnswerChange(value: String) {
        _uiState.update { it.copy(answer = value) }
    }

    fun saveCard(onSaved: () -> Unit) {
        val question = _uiState.value.question
        val answer = _uiState.value.answer

        if (question.isBlank() || answer.isBlank()) return

        viewModelScope.launch {
            dao.insertFlashCard(
                listOf(
                    FlashcardEntity(
                        deckId = deckId,
                        question = question,
                        answer = answer
                    )
                )
            )

            _uiState.value = AddUiState()

            onSaved()
        }
    }
}