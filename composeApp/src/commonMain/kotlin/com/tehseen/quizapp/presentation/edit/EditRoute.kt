package com.tehseen.quizapp.presentation.edit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tehseen.quizapp.presentation.edit.presentation.EditViewModel

@Composable
fun EditRoute(
    viewModel: EditViewModel = viewModel(),
    onNavigateToSession : () -> Unit
){
    val state by viewModel.uiState.collectAsState()

    EditFlashcard(
        state =state,
        onUpdateClick = onNavigateToSession
    )
}