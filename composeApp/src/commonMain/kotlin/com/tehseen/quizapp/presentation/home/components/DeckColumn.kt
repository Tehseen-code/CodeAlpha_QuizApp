package com.tehseen.quizapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeckColumn(
    decks: List<Deck>,
    onDeckClick: (Long) -> Unit,
    onDeckLongClick: (Long) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(decks) { deck ->
            DeckItem(
                deck = deck,
                onDeckClick = {
                    onDeckClick(deck.id)
                },
                onLongClick = {
                    onDeckLongClick(deck.id)
                }
            )
        }
    }
}

data class Deck(
    val id: Long,
    val title: String,
    val info: String
)