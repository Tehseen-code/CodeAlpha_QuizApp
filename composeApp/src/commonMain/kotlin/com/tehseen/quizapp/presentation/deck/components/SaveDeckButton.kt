package com.tehseen.quizapp.presentation.deck.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SaveDeckButton(
    onSaveDeckClick: () -> Unit,
    onAddCardClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "+ Add Another Card",
            color = Color.Blue,
            modifier = Modifier.clickable {
                onAddCardClick()
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onSaveDeckClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = "Save Deck",
                fontWeight = FontWeight.Bold
            )
        }
    }
}