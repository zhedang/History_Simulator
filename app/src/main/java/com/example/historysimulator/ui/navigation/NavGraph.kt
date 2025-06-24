package com.example.historysimulator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.historysimulator.ui.screens.StartMenuScreen
import com.example.historysimulator.ui.screens.ChooseEraScreen

object Routes {
    const val StartMenu = "start_menu"
    const val ChooseEra = "choose_era"
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.StartMenu) {
        composable(Routes.StartMenu) {
            StartMenuScreen(
                onStartSimulation = {
                    navController.navigate(Routes.ChooseEra)
                }
            )
        }
        composable(Routes.ChooseEra) {
            ChooseEraScreen(
                onEraSelected = { era ->
                    // For now we don't handle it, just stay here
                }
            )
        }
    }
}
