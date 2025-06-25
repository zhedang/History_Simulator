package com.example.historysimulator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.historysimulator.ui.screens.StartMenuScreen
import com.example.historysimulator.ui.screens.ChooseEraScreen
import com.example.historysimulator.ui.screens.BackgroundScreen
import com.google.gson.Gson
import com.example.historysimulator.model.Era


object Routes {
    const val StartMenu = "start_menu"
    const val ChooseEra = "choose_era"
    const val Background = "background"
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
        val gson = Gson()
        composable(Routes.ChooseEra) {
            ChooseEraScreen(
                onEraSelected = { eraName ->
                    // Serialize Era to JSON string
                    val era = Era(name = eraName)
                    val eraJson = gson.toJson(era)
                    navController.navigate("${Routes.Background}/$eraJson")
                }
            )
        }
        composable(
            route = "${Routes.Background}/{eraJson}",
            arguments = listOf(navArgument("eraJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val eraJson = backStackEntry.arguments?.getString("eraJson")
            val era = gson.fromJson(eraJson, Era::class.java)
            BackgroundScreen(
                era = era,
                onGenerateBackground = { /* TODO: LLM, for now do nothing */ },
                onContinue = { /* TODO: Next step */ }
            )
        }
    }
}
