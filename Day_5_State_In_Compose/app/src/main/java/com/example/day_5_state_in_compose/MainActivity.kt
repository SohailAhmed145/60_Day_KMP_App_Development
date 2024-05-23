package com.example.day_5_state_in_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.day_5_state_in_compose.ui.Wellness
import com.example.day_5_state_in_compose.ui.theme.Day_5_State_In_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Day_5_State_In_ComposeTheme {
               Surface(
                   modifier = Modifier.fillMaxSize().padding(top = 20.dp),
                   color = MaterialTheme.colorScheme.background
               ) {
                   Wellness()
               }
            }
        }
    }
}
