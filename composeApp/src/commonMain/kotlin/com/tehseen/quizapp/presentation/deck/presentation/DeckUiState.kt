package com.tehseen.quizapp.presentation.deck.presentation

import com.tehseen.quizapp.presentation.deck.components.FlashCard

data class DeckUiState(
    val deckTitle : String = "",
    val flashCards : List<FlashCard> = emptyList(),
)
