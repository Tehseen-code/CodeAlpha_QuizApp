package com.tehseen.quizapp.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun FlashCardExist(){
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ){
        Info()
        Spacer(modifier = Modifier.height(16.dp))
        DeckColumn()
    }
}