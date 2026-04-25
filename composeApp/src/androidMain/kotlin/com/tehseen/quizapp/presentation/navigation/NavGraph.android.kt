package com.tehseen.quizapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tehseen.quizapp.presentation.add.AddScreen
import com.tehseen.quizapp.presentation.deck.DeckScreen
import com.tehseen.quizapp.presentation.delete.DeleteCard
import com.tehseen.quizapp.presentation.edit.EditFlashcard
import com.tehseen.quizapp.presentation.home.HomeScreen
import com.tehseen.quizapp.presentation.splash.SplashScreen
import com.tehseen.quizapp.presentation.studySession.StudySessionScreen

@Composable
actual fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ){
        composable("splash"){
            SplashScreen(
                onNavigate = {
                    navController.navigate("home") {
                        popUpTo("splash") {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable("home"){
            HomeScreen(
                onAddClick = {
                    navController.navigate("deck")
                },
                onDeckClick = {
                    navController.navigate("studySession")
                }
            )
        }
        composable("deck"){
            DeckScreen(
                onSaveDeckClick = {
                    navController.navigate("home")
                }
            )
        }
        composable("studySession"){
            StudySessionScreen(
                onAddClick = {
                    navController.navigate("addScreen")
                },
                onEditClick = {
                    navController.navigate("editScreen")
                },
                onDeleteClick = {
                    navController.navigate("deleteScreen")
                }
            )
        }
        composable("addScreen"){
            AddScreen()
        }
        composable("editScreen"){
            EditFlashcard()
        }
        composable("deleteScreen"){
            DeleteCard()
        }


    }
}