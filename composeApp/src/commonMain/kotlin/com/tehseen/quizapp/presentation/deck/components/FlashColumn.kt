package com.tehseen.quizapp.presentation.deck.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tehseen.quizapp.presentation.deck.presentation.FlashCardUi

@Composable
fun FlashColumn(
    flashes: List<FlashCardUi>,
    onQuestionChange: (Int, String) -> Unit,
    onAnswerChange: (Int, String) -> Unit,
    onDeleteClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(flashes) { index, item ->
            FlashItem(
                index = index,
                flashCard = item,
                onQuestionChange = {
                    onQuestionChange(index, it)
                },
                onAnswerChange = {
                    onAnswerChange(index, it)
                },
                onDeleteClick = {
                    onDeleteClick(index)
                }
            )
        }
    }
}