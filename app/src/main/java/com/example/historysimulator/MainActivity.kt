package com.example.historysimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.navigation.compose.rememberNavController
import com.example.historysimulator.ui.navigation.NavGraph
import com.example.historysimulator.ui.theme.HistorySimulatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HistorySimulatorTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
