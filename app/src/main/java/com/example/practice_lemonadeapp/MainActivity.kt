package com.example.practice_lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_lemonadeapp.ui.theme.Practice_LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice_LemonadeAppTheme {
                LemonadeAppPreview()
            }
        }
    }
}
enum class LemonadeState {
    Harvesting, Squeezing, Filled, Empty
}

@Composable
fun LemonadeInteractiveButton(modifier: Modifier = Modifier){
    val lemonadeState: LemonadeState by remember { mutableStateOf(LemonadeState.Harvesting) }
    var filledGlassPercentage = 0.0f

    Column(modifier,
        horizontalAlignment = Alignment.CenterHorizontally){
        Button( onClick = {} ) {
            Image(
                painter = painterResource(when(lemonadeState){
                    LemonadeState.Harvesting -> R.drawable.lemon_tree
                    LemonadeState.Squeezing -> R.drawable.lemon_squeeze
                    LemonadeState.Filled -> R.drawable.lemon_drink
                    LemonadeState.Empty -> R.drawable.lemon_restart
                }),
                contentDescription = lemonadeState.toString()
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = when(lemonadeState){
                LemonadeState.Harvesting -> stringResource(R.string.lemon_tree_instruction)
                LemonadeState.Squeezing -> stringResource(R.string.lemon_squeeze_instruction) + " $filledGlassPercentage% squeezed!"
                LemonadeState.Filled -> stringResource(R.string.lemon_drink_instruction)
                LemonadeState.Empty -> stringResource(R.string.lemon_restart_instruction)
            }
        )
    }
}

@Preview(showSystemUi = true,
    showBackground = true)
@Composable
fun LemonadeAppPreview(){
    LemonadeInteractiveButton(
        Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}