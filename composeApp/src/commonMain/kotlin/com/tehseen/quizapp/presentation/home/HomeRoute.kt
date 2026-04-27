package com.tehseen.quizapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tehseen.quizapp.presentation.home.presentation.HomeViewModel
import com.tehseen.quizapp.presentation.navigation.Screen

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = viewModel(),
    onNavigateToAdd: (Screen) -> Unit,
    onNavigateToDeck: (Screen) -> Unit,
){
    val state by viewModel.uiState.collectAsState()
    HomeScreen(
        onAddClick = {onNavigateToAdd(Screen.DECK)},
        onDeckClick = {onNavigateToDeck(Screen.STUDY_SESSION)},
        state = state
    )
}
