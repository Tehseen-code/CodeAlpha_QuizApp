package com.tehseen.quizapp.presentation.edit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tehseen.quizapp.data.local.QuizDao
import com.tehseen.quizapp.presentation.edit.presentation.EditViewModel

@Composable
fun EditRoute(
    dao: QuizDao,
    cardId: Long,
    onNavigateBack: () -> Unit,
    onBackClick: () -> Unit
) {
    val viewModel: EditViewModel = viewModel(
        factory = viewModelFactory {
            initializer {
                EditViewModel(dao, cardId)
            }
        }
    )

    val state by viewModel.uiState.collectAsState()

    EditFlashcard(
        state = state,
        onUpdateClick = {
            viewModel.updateCard(onComplete = onNavigateBack)
        },
        // QandA component ko ye callbacks pass karein
        onQuestionChange = { viewModel.onQuestionChange(it) },
        onAnswerChange = { viewModel.onAnswerChange(it) },
        onBackClick = onBackClick
    )
}