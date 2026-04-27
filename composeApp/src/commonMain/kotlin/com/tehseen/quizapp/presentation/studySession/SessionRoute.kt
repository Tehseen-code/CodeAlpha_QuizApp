package com.tehseen.quizapp.presentation.studySession

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tehseen.quizapp.presentation.studySession.presentation.SessionViewModel

@Composable
fun SessionRoute(
    viewModel: SessionViewModel = viewModel(),
    onNavigateToAdd : () -> Unit,
    onNavigateToEdit : () -> Unit,
){
    val state by viewModel.uiState.collectAsState()
    StudySessionScreen(
        state = state ,
        onAddClick = onNavigateToAdd,
        onEditClick = onNavigateToEdit,
        onDeleteClick = viewModel::showDialog,
        onCancelDelete = viewModel::hideDeleteDialog,
        onConfirmDelete =viewModel::deleteCurrentCard
    )
}