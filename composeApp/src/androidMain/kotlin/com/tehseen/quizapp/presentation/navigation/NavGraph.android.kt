package com.tehseen.quizapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tehseen.quizapp.data.local.getDatabaseBuilder
import com.tehseen.quizapp.presentation.add.AddRoute
import com.tehseen.quizapp.presentation.deck.DeckRoute
import com.tehseen.quizapp.presentation.edit.EditRoute
import com.tehseen.quizapp.presentation.home.HomeRoute
import com.tehseen.quizapp.presentation.splash.SplashScreen
import com.tehseen.quizapp.presentation.studySession.SessionRoute

@Composable
actual fun NavGraph() {
    val navController = rememberNavController()

    val context = LocalContext.current
    val db = remember {
        getDatabaseBuilder(context).build()
    }
    val dao = db.quizDao()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
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

        composable("home") {
            HomeRoute(
                dao = dao,
                onNavigateToAdd = {
                    navController.navigate("deck")
                },
                onNavigateToDeck = { deckId ->
                    navController.navigate("studySession/$deckId")
                }
            )
        }

        composable("deck") {
            DeckRoute(
                dao = dao,
                onNavigateToHome = {
                    navController.popBackStack()
                }
            )
        }

        composable("studySession/{deckId}") { backStackEntry ->
            val deckId = backStackEntry.arguments
                ?.getString("deckId")
                ?.toLongOrNull() ?: 0L

            SessionRoute(
                dao = dao,
                deckId = deckId,
                onNavigateToAdd = {
                    navController.navigate("addScreen")
                },
                onNavigateToEdit = {
                    navController.navigate("editScreen")
                }
            )
        }

        composable("addScreen") {
            AddRoute(
                onNavigateToSession = {
                    navController.popBackStack()
                }
            )
        }

        composable("editScreen") {
            EditRoute(
                onNavigateToSession = {
                    navController.popBackStack()
                }
            )
        }
    }
}