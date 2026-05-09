package com.tehseen.quizapp.presentation.home.presentation

import com.tehseen.quizapp.presentation.home.components.Deck

data class HomeUiState(
    val decks : List<Deck> = emptyList(),
    val isLoading : Boolean = false,
    val showDeleteDialog: Boolean = false,
    val selectedDeckId: Long? = null
)
