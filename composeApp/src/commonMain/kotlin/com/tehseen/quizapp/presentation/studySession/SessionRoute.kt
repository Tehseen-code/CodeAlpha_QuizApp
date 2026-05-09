package com.tehseen.quizapp.presentation.studySession

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tehseen.quizapp.data.local.QuizDao
import com.tehseen.quizapp.presentation.studySession.presentation.SessionViewModel

@Composable
fun SessionRoute(
    dao: QuizDao,
    deckId: Long,
    onNavigateToAdd: () -> Unit,
    onNavigateToEdit: (Long) -> Unit, //Yahan Long argument add karein
    onBackClick: () -> Unit
) {
    val viewModel: SessionViewModel = viewModel(
        factory = viewModelFactory {
            initializer {
                SessionViewModel(dao, deckId)
            }
        }
    )

    val state by viewModel.uiState.collectAsState()

    StudySessionScreen(
        state = state,
        onAddClick = onNavigateToAdd,
        // Yahan state se current card ki ID pass karein
        onEditClick = {
            val currentCardId = state.cards.getOrNull(state.currentIndex)?.id
            if (currentCardId != null) {
                onNavigateToEdit(currentCardId)
            }
        },
        onDeleteClick = viewModel::showDialog,
        onCancelDelete = viewModel::hideDeleteDialog,
        onConfirmDelete = viewModel::deleteCurrentCard,
        onToggleAnswer = viewModel::toggleAnswer,
        onPrevious = viewModel::previousCard,
        onNext = viewModel::nextCard,
        onBackClick = onBackClick
    )
}