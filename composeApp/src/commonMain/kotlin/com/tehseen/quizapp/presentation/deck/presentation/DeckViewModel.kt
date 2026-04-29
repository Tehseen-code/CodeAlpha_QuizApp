package com.tehseen.quizapp.presentation.deck.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tehseen.quizapp.data.local.FlashcardEntity
import com.tehseen.quizapp.data.local.QuizDao
import com.tehseen.quizapp.data.local.QuizEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DeckViewModel(private val dao: QuizDao): ViewModel(){
    private val _uiState = MutableStateFlow(DeckUiState())
    val uiState: StateFlow<DeckUiState> = _uiState.asStateFlow()


    fun onTitleChange(newTitle: String) {
        _uiState.value = _uiState.value.copy(deckTitle = newTitle)
    }
    fun onQuestionChange(index: Int, value: String) {
        val updated = _uiState.value.flashCards.toMutableList()
        updated[index] = updated[index].copy(question = value)

        _uiState.value = _uiState.value.copy(flashCards = updated)
    }

    fun onAnswerChange(index: Int, value: String) {
        val updated = _uiState.value.flashCards.toMutableList()
        updated[index] = updated[index].copy(answer = value)

        _uiState.value = _uiState.value.copy(flashCards = updated)
    }

    fun addNewCard() {
        _uiState.value = _uiState.value.copy(
            flashCards = _uiState.value.flashCards + FlashCardUi()
        )
    }

    fun saveDeck(onSaved: () -> Unit) {
        val title = _uiState.value.deckTitle
        val cards = _uiState.value.flashCards

        if (title.isBlank()) return

        viewModelScope.launch {
            val deckId = dao.insertDeck(
                QuizEntity(title = title)
            )

            val entities = cards
                .filter {
                    it.question.isNotBlank() || it.answer.isNotBlank()
                }
                .map {
                    FlashcardEntity(
                        deckId = deckId,
                        question = it.question,
                        answer = it.answer
                    )
                }

            dao.insertFlashCard(entities)

            onSaved()
        }
    }
    fun deleteCard(index: Int) {
        val updated = _uiState.value.flashCards.toMutableList()

        if (updated.size > 1) {
            updated.removeAt(index)

            _uiState.value = _uiState.value.copy(
                flashCards = updated
            )
        }
    }
}