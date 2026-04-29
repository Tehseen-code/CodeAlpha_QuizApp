package com.tehseen.quizapp.presentation.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tehseen.quizapp.data.local.QuizDao
import com.tehseen.quizapp.presentation.home.components.Deck
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val dao : QuizDao): ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        observeDecks()
    }

    private fun observeDecks() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            dao.getAllQuizzes().collect { entities ->
                val uiDecks = entities.map { entity ->
                    val count = dao.getCardsCountForDeck(entity.id)
                    Deck(
                        id = entity.id,
                        title = entity.title,
                        info = "$count Cards"
                    )
                }

                _uiState.update {
                    it.copy(decks = uiDecks, isLoading = false)
                }
            }
        }
    }

}