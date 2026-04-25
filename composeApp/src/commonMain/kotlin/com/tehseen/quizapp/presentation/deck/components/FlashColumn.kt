package com.tehseen.quizapp.presentation.deck.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun FlashColumn(){
    val flashes = remember {
        mutableStateListOf(
            FlashCard("What is the capital of France?", "Paris"),
            FlashCard("What is the largest planet?", "Jupiter"),
            FlashCard("What is the largest country?", "Russia"),
            FlashCard("What is the highest mountain?", "Mount Everest"),
            FlashCard("What is the smallest country?", "Vatican City"),
        )
    }
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(flashes) { index, item ->
            FlashItem(
                flashCard = item
            )
        }
    }
}
data class FlashCard(
    var question:String,
    var answer:String
)