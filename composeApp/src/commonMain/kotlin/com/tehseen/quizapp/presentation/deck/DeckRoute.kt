package com.tehseen.quizapp.presentation.deck

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tehseen.quizapp.data.local.QuizDao
import com.tehseen.quizapp.presentation.deck.presentation.DeckViewModel

@Composable
fun DeckRoute(
    dao: QuizDao,
    onNavigateToHome: () -> Unit,
    onBackClick: () -> Unit
) {
    val viewModel: DeckViewModel = viewModel(
        factory = viewModelFactory {
            initializer {
                DeckViewModel(dao)
            }
        }
    )

    val state by viewModel.uiState.collectAsState()

    DeckScreen(
        state = state,

        onTitleChange = viewModel::onTitleChange,

        onQuestionChange = viewModel::onQuestionChange,

        onAnswerChange = viewModel::onAnswerChange,

        onAddCardClick = viewModel::addNewCard,

        onDeleteCardClick = viewModel::deleteCard,

        onSaveDeckClick = {
            viewModel.saveDeck {
                onNavigateToHome()
            }
        },
        onBackClick = onBackClick
    )
}