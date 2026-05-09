package com.tehseen.quizapp.presentation.deck

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tehseen.quizapp.presentation.deck.components.FlashColumn
import com.tehseen.quizapp.presentation.deck.components.Header
import com.tehseen.quizapp.presentation.deck.components.SaveDeckButton
import com.tehseen.quizapp.presentation.deck.components.Title
import com.tehseen.quizapp.presentation.deck.presentation.DeckUiState

@Composable
fun DeckScreen(
    state: DeckUiState,
    onTitleChange: (String) -> Unit,
    onQuestionChange: (Int, String) -> Unit,
    onAnswerChange: (Int, String) -> Unit,
    onAddCardClick: () -> Unit,
    onDeleteCardClick: (Int) -> Unit,
    onSaveDeckClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding()
    ) {
        Header(
            onBackClick = onBackClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        Title(
            value = state.deckTitle,
            onValueChange = onTitleChange,
            cardCount = state.flashCards.size
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier.weight(1f)) {
            FlashColumn(
                flashes = state.flashCards,
                onQuestionChange = onQuestionChange,
                onAnswerChange = onAnswerChange,
                onDeleteClick = onDeleteCardClick
            )
        }

        SaveDeckButton(
            onSaveDeckClick = onSaveDeckClick,
            onAddCardClick = onAddCardClick
        )
    }
}