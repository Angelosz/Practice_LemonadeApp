package com.example.practice_lemonadeapp

import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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


@Composable
fun LemonadeInteractiveButton(modifier: Modifier = Modifier){

    Column(modifier,
        horizontalAlignment = Alignment.CenterHorizontally){
        Button( onClick = {} ) {
            Image(
                painter = painterResource(R.drawable.lemon_tree),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Text"
        )
    }
}

@Preview(showSystemUi = true,
    showBackground = true)
@Composable
fun LemonadeAppPreview(){
    LemonadeInteractiveButton(Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}