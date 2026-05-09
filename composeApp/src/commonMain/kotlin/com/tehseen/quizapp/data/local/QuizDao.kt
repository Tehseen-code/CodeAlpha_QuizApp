package com.tehseen.quizapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
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
    fun getCardsCountForDeck(deckId: Long): Flow<Int>

    @Query("SELECT * FROM flashcards WHERE deckId = :deckId")
    fun getFlashCardsForDeck(deckId: Long): Flow<List<FlashcardEntity>>

    @Query("DELETE FROM flashcards WHERE id = :cardId")
    suspend fun deleteFlashCardById(cardId: Long)

    @Query("DELETE FROM quizzes WHERE id = :deckId")
    suspend fun deleteDeckById(deckId: Long)

    @Update
    suspend fun updateFlashCard(card: FlashcardEntity)

    @Query("SELECT * FROM flashcards WHERE id = :cardId LIMIT 1")
    suspend fun getFlashCardById(cardId: Long): FlashcardEntity?
}