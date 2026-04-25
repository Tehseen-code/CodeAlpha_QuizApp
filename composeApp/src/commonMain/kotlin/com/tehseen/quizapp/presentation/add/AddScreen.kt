package com.tehseen.quizapp.presentation.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tehseen.quizapp.presentation.add.components.Header
import com.tehseen.quizapp.presentation.add.components.QuestionAnswer
import com.tehseen.quizapp.presentation.add.components.SaveButton

@Preview(showSystemUi = true)
@Composable
fun AddScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding()
    ){
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        QuestionAnswer()
        Spacer(modifier = Modifier.weight(1f))
        SaveButton()
    }
}
