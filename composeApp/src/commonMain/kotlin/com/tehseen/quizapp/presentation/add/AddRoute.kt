package com.tehseen.quizapp.presentation.add

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tehseen.quizapp.data.local.QuizDao
import com.tehseen.quizapp.presentation.add.presentation.AddViewModel

@Composable
fun AddRoute(
    deckId : Long,
    dao: QuizDao,
    onNavigateToSession : () -> Unit,
    onBackClick: () -> Unit
){
    val viewModel: AddViewModel = viewModel(
        factory = viewModelFactory {
            initializer {
                AddViewModel(dao, deckId)
            }
        }
    )
    val state by viewModel.uiState.collectAsState()

    AddScreen(
        state = state,
        onSaveCardClick = {
            viewModel.saveCard {
                onNavigateToSession()
            }
        },
        onQuestionChange = viewModel::onQuestionChange,
        onAnswerChange = viewModel::onAnswerChange,
        onBackClick = onBackClick
    )
}