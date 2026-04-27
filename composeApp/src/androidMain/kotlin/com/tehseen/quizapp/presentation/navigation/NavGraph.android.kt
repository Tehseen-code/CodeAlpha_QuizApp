package com.tehseen.quizapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tehseen.quizapp.presentation.add.AddRoute
import com.tehseen.quizapp.presentation.deck.DeckRoute
import com.tehseen.quizapp.presentation.edit.EditRoute
import com.tehseen.quizapp.presentation.home.HomeRoute
import com.tehseen.quizapp.presentation.splash.SplashScreen
import com.tehseen.quizapp.presentation.studySession.SessionRoute

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
            HomeRoute(
                onNavigateToAdd ={
                    navController.navigate("deck")
                },
                onNavigateToDeck = {
                    navController.navigate("studySession")
                }
            )
        }
        composable("deck"){
            DeckRoute(
                onNavigateToHome = {
                    navController.navigate("home")
                }
            )
        }
        composable("studySession"){
            SessionRoute(
                onNavigateToAdd = {
                    navController.navigate("addScreen")
                },
                onNavigateToEdit = {
                    navController.navigate("editScreen")
                }
            )
        }
        composable("addScreen"){
            AddRoute(
                onNavigateToSession = {
                    navController.navigate("studySession")

                }
            )
        }
        composable("editScreen"){
            EditRoute(
                onNavigateToSession = {
                    navController.navigate("studySession")
                }
            )
        }

    }
}