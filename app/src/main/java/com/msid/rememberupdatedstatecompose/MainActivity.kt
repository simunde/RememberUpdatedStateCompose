package com.msid.rememberupdatedstatecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.msid.rememberupdatedstatecompose.ui.theme.RememberUpdatedStateComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

fun b(){
    Log.d("MUSID","I am from  B")

}

fun a(){
    Log.d("MUSID","I am from A")
}
@Composable
fun App(){
    var state = remember { mutableStateOf(::a) }
    
    Button(onClick = { state.value = ::b}) {
        Text(text = "Click to change state")
    }

    LandingScreen(state.value)

    }


@Composable
fun LandingScreen(onTimeout:()-> Unit){
    val currentOnTimeout by rememberUpdatedState(onTimeout)
    LaunchedEffect(key1 = true) {
        delay(5000)
        currentOnTimeout()
        
    }
}