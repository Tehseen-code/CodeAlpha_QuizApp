package com.tehseen.quizapp.presentation.add

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tehseen.quizapp.presentation.add.presentation.AddViewModel

@Composable
fun AddRoute(
    viewModel: AddViewModel = viewModel(),
    onNavigateToSession : () -> Unit
){
    val state by viewModel.uiState.collectAsState()

    AddScreen(
        state = state,
        onSaveCardClick = onNavigateToSession
    )
}