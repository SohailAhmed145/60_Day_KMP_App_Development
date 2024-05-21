package com.example.day_2_5_jetpack_compose_basics.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.day_2_5_jetpack_compose_basics.R


@ExperimentalMaterial3Api
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
){
    Surface (
        shape = MaterialTheme.shapes.small,
        modifier = Modifier,
        color = Color(0xffffdad6),
    ) {
    TextField(
        value = "",
        onValueChange ={} ,
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(stringResource(id = R.string.placeholder_search))
        },
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xffffdad6),
            unfocusedContainerColor = Color(0xFFDA8873)
            ),

    )
}

}
