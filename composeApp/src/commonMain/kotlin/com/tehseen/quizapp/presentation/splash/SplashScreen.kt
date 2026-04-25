package com.tehseen.quizapp.presentation.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import quizapp.composeapp.generated.resources.Res
import quizapp.composeapp.generated.resources.compose_multiplatform

@Preview(showSystemUi = true)
@Composable
fun SplashScreen(
    onNavigate: () -> Unit = {}
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var startAnimation by remember { mutableStateOf(false) }

        val progressAnimation by animateFloatAsState(
            targetValue = if (startAnimation) 1f else 0f,
            animationSpec = tween(
                durationMillis = 3000,
                easing = LinearEasing
            )
        )
        LaunchedEffect(Unit) {
            startAnimation = true
        }
        LaunchedEffect(progressAnimation){
            if (progressAnimation >= 1f){
                onNavigate()
            }
        }
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "appLogo",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "FlashCard Quiz",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Learn smarter everyday",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(120.dp))
        LinearProgressIndicator(
            progress = { progressAnimation },
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "SYNCING KNOWLEDGE",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(60.dp))
    }
}