package com.example.historysimulator.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ChooseEraScreen(
    onEraSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        Text(
            text = "Choose Era",
            fontSize = 28.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2196F3))
                .padding(12.dp)
        )

        Spacer(Modifier.height(24.dp))

        // Era options
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { onEraSelected("Colonial") }) {
                Text("Colonial Period")
            }
            Spacer(Modifier.height(16.dp))
            Button(onClick = { onEraSelected("Revolution") }) {
                Text("Revolutionary Period")
            }
            Spacer(Modifier.height(16.dp))
            Button(onClick = { onEraSelected("Constitution") }) {
                Text("Constitutional Period")
            }
        }
    }
}
