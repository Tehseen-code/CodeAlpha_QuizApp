package com.tehseen.quizapp.presentation.studySession.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tehseen.quizapp.data.local.QuizDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SessionViewModel(
    private val dao: QuizDao,
    private val deckId: Long
) : ViewModel() {

    private val _uiState = MutableStateFlow(SessionUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadCards()
    }

    private fun loadCards() {
        viewModelScope.launch {
            val cards = dao.getFlashCardsForDeck(deckId)

            _uiState.update {
                it.copy(cards = cards)
            }
        }
    }

    fun toggleAnswer() {
        _uiState.update {
            it.copy(showAnswer = !it.showAnswer)
        }
    }

    fun nextCard() {
        _uiState.update {
            if (it.currentIndex < it.cards.lastIndex) {
                it.copy(
                    currentIndex = it.currentIndex + 1,
                    showAnswer = false
                )
            } else it
        }
    }

    fun previousCard() {
        _uiState.update {
            if (it.currentIndex > 0) {
                it.copy(
                    currentIndex = it.currentIndex - 1,
                    showAnswer = false
                )
            } else it
        }
    }
    fun showDialog() {
        _uiState.update {
            it.copy(showDeleteDialog = true)
        }
    }

    fun hideDeleteDialog() {
        _uiState.update {
            it.copy(showDeleteDialog = false)
        }
    }

    fun deleteCurrentCard() {
        hideDeleteDialog()
    }
}