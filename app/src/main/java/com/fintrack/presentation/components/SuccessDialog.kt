package com.fintrack.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fintrack.R

/**
 * Created by fasil on 01/03/25.
 */
@androidx.compose.runtime.Composable
fun SuccessDialog(onDismiss: () -> Unit) {
    Dialog(
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
        onDismissRequest = onDismiss
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.success))
        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = 1
        )
        LaunchedEffect(progress) {
            if (progress == 1f) {
                onDismiss()
            }
        }
        Card {
            Box(Modifier.padding(12.dp)) {
                LottieAnimation(composition, progress = { progress }, modifier = Modifier.size(150.dp))
            }
        }
    }
}