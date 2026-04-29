package com.tehseen.quizapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tehseen.quizapp.data.local.QuizDao
import com.tehseen.quizapp.presentation.home.presentation.HomeViewModel
import com.tehseen.quizapp.presentation.navigation.Screen

@Composable
fun HomeRoute(
    dao: QuizDao,
    onNavigateToAdd: (Screen) -> Unit,
    onNavigateToDeck: (Long) -> Unit
) {
    val viewModel: HomeViewModel = viewModel(
        factory = viewModelFactory {
            initializer {
                HomeViewModel(dao)
            }
        }
    )

    val state by viewModel.uiState.collectAsState()

    HomeScreen(
        state = state,
        onAddClick = {
            onNavigateToAdd(Screen.DECK)
        },
        onDeckClick = { deckId ->
            onNavigateToDeck(deckId)
        }
    )
}