package com.tehseen.quizapp.presentation.deck.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tehseen.quizapp.presentation.deck.presentation.FlashCardUi

@Composable
fun FlashItem(
    index: Int,
    flashCard: FlashCardUi,
    onQuestionChange: (String) -> Unit,
    onAnswerChange: (String) -> Unit,
    onDeleteClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "CARD #${index + 1}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Delete",
                    tint = Color.Red,
                    modifier = Modifier.clickable {
                        onDeleteClick?.invoke()
                    }
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = flashCard.question,
                onValueChange = onQuestionChange,
                label = { Text("Question") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = flashCard.answer,
                onValueChange = onAnswerChange,
                label = { Text("Answer") },
                maxLines = 4,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}