package com.tehseen.quizapp.presentation.edit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tehseen.quizapp.presentation.edit.presentation.EditUiState

@Composable
fun QandA(
    state: EditUiState,
    onQuestionChange: (String) -> Unit,
    onAnswerChange: (String) -> Unit
){
    Column(modifier = Modifier.fillMaxWidth()){
        OutlinedTextField(
            value = state.question,
            onValueChange = onQuestionChange, // ViewModel ka function call hoga
            label = { Text("Question") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = state.answer,
            onValueChange = onAnswerChange, // ViewModel ka function call hoga
            label = { Text("Answer") },
            maxLines = 4,
            modifier = Modifier.fillMaxWidth()
        )
    }
}