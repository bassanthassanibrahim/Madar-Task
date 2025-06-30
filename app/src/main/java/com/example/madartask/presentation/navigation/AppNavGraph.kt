package com.example.madartask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.madartask.presentation.screens.DisplayScreen
import com.example.madartask.presentation.screens.InputScreen

object Routes {
    const val INPUT = "input"
    const val DISPLAY = "display"
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.INPUT) {
        composable(Routes.INPUT) {
            InputScreen(
                onUserSaved = {
                    navController.navigate(Routes.DISPLAY)
                }
            )
        }

        composable(Routes.DISPLAY) {
            DisplayScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}



