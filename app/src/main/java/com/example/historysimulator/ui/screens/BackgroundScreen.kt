package com.example.historysimulator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.historysimulator.model.Era

@Composable
fun BackgroundScreen(
    era: Era,
    onGenerateBackground: () -> Unit,
    onContinue: () -> Unit
) {
    var backgroundText by remember { mutableStateOf("placeholder, wait to be filled") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        // Top bar
        Text(
            text = "Background",
            fontSize = 24.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2196F3))
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Show chosen era and tip
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Era chosen: ${era.name}", fontSize = 20.sp)
            Spacer(Modifier.height(8.dp))
            if (era.years.isNotBlank()) {
                Text(era.years, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Generate background button
        Button(
            onClick = {
                // Will call LLM in the future
                onGenerateBackground()
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Generate Background")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Placeholder text
        Text(
            text = backgroundText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.weight(1f))

        // Continue button at the bottom
        Button(
            onClick = onContinue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text("Continue")
        }
    }
}
