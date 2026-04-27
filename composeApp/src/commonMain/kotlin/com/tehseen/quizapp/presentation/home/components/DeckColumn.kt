package com.tehseen.quizapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeckColumn(
    onDeckClick : (Deck) -> Unit,
    decks : List<Deck>
){


    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        itemsIndexed(decks){index , deck ->
            DeckItem(
                deck = deck,
                onDeckClick = { onDeckClick(deck) }
            )
        }
    }

}
data class Deck(
    val title : String,
    val count : String
)