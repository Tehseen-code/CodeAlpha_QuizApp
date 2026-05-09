package com.tehseen.quizapp.presentation.studySession.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tehseen.quizapp.data.local.QuizDao
import kotlinx.coroutines.flow.MutableStateFlow
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
        observeCards()
    }

    /**
     * Database ko observe karne ka tareeqa.
     * Jab bhi Room mein data change hoga, ye block auto-run hoga.
     */
    private fun observeCards() {
        viewModelScope.launch {
            // Room hamesha updated list "push" karega
            dao.getFlashCardsForDeck(deckId).collect { updatedCards ->
                _uiState.update { state ->
                    // Index ko validate karein taake delete ke baad app crash na ho
                    val validatedIndex = if (updatedCards.isEmpty()) {
                        0
                    } else {
                        state.currentIndex.coerceIn(0, updatedCards.lastIndex)
                    }

                    state.copy(
                        cards = updatedCards,
                        currentIndex = validatedIndex,
                    )
                }
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
        val current = _uiState.value.currentCard ?: return

        viewModelScope.launch {
            // Sirf database se delete karein
            dao.deleteFlashCardById(current.id)

            // observeCards() khud hi updated list handle kar lega aur UI refresh kar dega
            hideDeleteDialog()
            _uiState.update { it.copy(showAnswer = false) }
        }
    }
}