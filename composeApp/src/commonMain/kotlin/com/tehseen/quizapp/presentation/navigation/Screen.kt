package com.tehseen.quizapp.presentation.navigation

sealed class Screen {

    object HOME : Screen()
    object DECK : Screen()
    object STUDY_SESSION : Screen()
    object EDIT : Screen()
    object ADD : Screen()
}