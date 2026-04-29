package com.tehseen.quizapp.presentation.studySession.presentation

import com.tehseen.quizapp.data.local.FlashcardEntity

data class SessionUiState(
    val cards: List<FlashcardEntity> = emptyList(),
    val currentIndex: Int = 0,
    val showAnswer: Boolean = false,
    val showDeleteDialog: Boolean = false
) {
    val currentCard: FlashcardEntity?
        get() = cards.getOrNull(currentIndex)
}
