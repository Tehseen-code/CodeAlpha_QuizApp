package com.tehseen.quizapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {
    @Insert
    suspend fun insertDeck(quiz: QuizEntity): Long

    @Insert
    suspend fun insertFlashCard(cards : List<FlashcardEntity>)

    @Query("SELECT * FROM quizzes")
    fun getAllQuizzes(): Flow<List<QuizEntity>>

    @Query("SELECT COUNT(*) FROM flashcards WHERE deckId = :deckId")
    suspend fun getCardsCountForDeck(deckId: Long): Int

    @Query("SELECT * FROM flashcards WHERE deckId = :deckId")
    suspend fun getFlashCardsForDeck(deckId: Long): List<FlashcardEntity>

}