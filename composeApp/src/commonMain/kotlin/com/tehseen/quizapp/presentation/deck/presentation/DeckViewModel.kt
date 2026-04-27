package com.tehseen.quizapp.presentation.deck.presentation

import androidx.lifecycle.ViewModel
import com.tehseen.quizapp.presentation.deck.components.FlashCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DeckViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(DeckUiState())
    val uiState: StateFlow<DeckUiState> = _uiState.asStateFlow()

    init {
        loadDeckDetails("C++")

    }

    fun loadDeckDetails(title : String){

        _uiState.update {
            it.copy(
                deckTitle = title
            )
        }
        val flashes = listOf(
            FlashCard("What is the capital of France?", "Paris"),
            FlashCard("What is the largest planet?", "Jupiter")
        )
        _uiState.update {
            it.copy(
                flashCards = flashes
            )
        }

    }
}