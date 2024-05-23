package com.example.day_5_state_in_compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Count(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableIntStateOf(0) }
    StateLessCount(
        count = count,
        onIncrement =  { count++ },
        modifier = Modifier

    )

}


@Composable
fun StateLessCount(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier){
    Column (modifier = Modifier.padding(16.dp)){
        if (count > 0) {
            Text(text = "your count is ${count}")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,   //it will show count till 10
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Add one")
        }
    }
}