package com.tehseen.quizapp.presentation.deck

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tehseen.quizapp.presentation.deck.presentation.DeckViewModel

@Composable
fun DeckRoute(
    viewModel: DeckViewModel = viewModel(),
    onNavigateToHome : () -> Unit
){
    val state by viewModel.uiState.collectAsState()

    DeckScreen(
        state = state,
        onSaveDeckClick = onNavigateToHome
    )
}