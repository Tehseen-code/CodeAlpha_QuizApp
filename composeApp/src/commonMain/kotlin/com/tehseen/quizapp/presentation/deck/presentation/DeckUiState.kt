package com.tehseen.quizapp.presentation.deck.presentation


data class DeckUiState(
    val deckTitle: String = "",
    val flashCards: List<FlashCardUi> = listOf(
        FlashCardUi()
    )
)

data class FlashCardUi(
    var question: String = "",
    var answer: String = ""
)