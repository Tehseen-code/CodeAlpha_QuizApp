package com.tehseen.quizapp.presentation.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tehseen.quizapp.presentation.edit.components.Header
import com.tehseen.quizapp.presentation.edit.components.QandA
import com.tehseen.quizapp.presentation.edit.components.UpdateButton
import com.tehseen.quizapp.presentation.edit.presentation.EditUiState

@Preview(showSystemUi = true)
@Composable
fun EditFlashcard(
    state : EditUiState,
    onUpdateClick : () -> Unit,
    onQuestionChange: (String) -> Unit,
    onAnswerChange: (String) -> Unit  ,
    onBackClick: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding()
    ){
        Header(
            onBackClick = onBackClick
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Yahan callbacks pass karein
        QandA(
            state = state,
            onQuestionChange = onQuestionChange,
            onAnswerChange = onAnswerChange
        )

        Spacer(modifier = Modifier.weight(1f))

        UpdateButton(
            onUpdateClick = onUpdateClick
        )
    }
}