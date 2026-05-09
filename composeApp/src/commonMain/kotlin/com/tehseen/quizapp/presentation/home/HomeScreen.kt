package com.tehseen.quizapp.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tehseen.quizapp.presentation.delete.DeleteCard
import com.tehseen.quizapp.presentation.home.components.FlashCardExist
import com.tehseen.quizapp.presentation.home.components.Header
import com.tehseen.quizapp.presentation.home.components.NoFlashCard
import com.tehseen.quizapp.presentation.home.presentation.HomeUiState

@Composable
fun HomeScreen(
    state: HomeUiState,
    onAddClick: () -> Unit,
    onDeckClick: (Long) -> Unit,
    onDeckLongClick: (Long) -> Unit,
    onDeleteConfirm: () -> Unit,
    onDeleteCancel: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .padding(16.dp)
            .statusBarsPadding(),
        topBar = {
            Header()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,
                containerColor = Color(0xFF0056D2),
                contentColor = Color.White,
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier.padding(paddingValues)
        ) {

            if (state.decks.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    NoFlashCard()
                }
            } else {
                FlashCardExist(
                    decks = state.decks,
                    onDeckClick = onDeckClick,
                    onDeckLongClick = onDeckLongClick
                )
            }

            if (state.showDeleteDialog) {
                DeleteCard(
                    onDismissRequest = onDeleteCancel,
                    onCancel = onDeleteCancel,
                    onDelete = onDeleteConfirm
                )
            }
        }
    }
}