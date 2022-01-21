package com.example.dsp.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.dsp.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun Expandable(

) {
    var expandableState = remember{ mutableStateOf(false)}
    Card(modifier = Modifier.fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                delayMillis = 300,
                easing = LinearOutSlowInEasing
            )
        ),
        shape = Shapes.medium,
        onClick = {

        }
    ) {

    }
}