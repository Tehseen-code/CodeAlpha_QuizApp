package com.tehseen.quizapp.presentation.home.presentation

import androidx.lifecycle.ViewModel
import com.tehseen.quizapp.presentation.home.components.Deck
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadDecks()
    }

    private fun loadDecks() {
        val mockData = listOf(
            Deck("C++", "10 Cards"),
            Deck("DSA", "22 Cards"),
            Deck("OOP", "42 Cards")
        )
        _uiState.update { it.copy(decks = mockData)}
    }
}