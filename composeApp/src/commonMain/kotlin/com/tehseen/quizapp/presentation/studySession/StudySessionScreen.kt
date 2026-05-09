package com.tehseen.quizapp.presentation.studySession

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tehseen.quizapp.presentation.delete.DeleteCard
import com.tehseen.quizapp.presentation.studySession.components.FlashcardComponent
import com.tehseen.quizapp.presentation.studySession.components.Header
import com.tehseen.quizapp.presentation.studySession.components.ProgressBar
import com.tehseen.quizapp.presentation.studySession.components.ShowAnswerButton
import com.tehseen.quizapp.presentation.studySession.presentation.SessionUiState

@Preview(showSystemUi = true)
@Composable
fun StudySessionScreen(
    state: SessionUiState,
    onAddClick : () -> Unit,
    onEditClick : () -> Unit,
    onDeleteClick : () -> Unit,
    onCancelDelete: () -> Unit,
    onConfirmDelete: () -> Unit,
    onToggleAnswer: () -> Unit,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onBackClick: () -> Unit
){
    val card = state.currentCard
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .statusBarsPadding()
    ){
        Header(
            onBackClick = onBackClick
        )
        Spacer(modifier = Modifier.height(20.dp))
        ProgressBar(
            currentIndex = state.currentIndex,
            totalCount = state.cards.size
        )
        Spacer(modifier = Modifier.height(20.dp))
        FlashcardComponent(
            question = card?.question.orEmpty(),
            answer = card?.answer.orEmpty(),
            showAnswer = state.showAnswer
        )
        Spacer(modifier = Modifier.height(20.dp))
        ShowAnswerButton(
            onAddClick = onAddClick,
            onEditClick = onEditClick,
            onDeleteClick = onDeleteClick,
            onShowAnswerClick = onToggleAnswer,
            onPreviousClick = onPrevious,
            onNextClick = onNext,
            showAnswer =state.showAnswer,
        )
        if (state.showDeleteDialog){
            DeleteCard(
                onDismissRequest =onCancelDelete ,
                onCancel =onCancelDelete ,
                onDelete = onConfirmDelete
            )
        }
    }
}
