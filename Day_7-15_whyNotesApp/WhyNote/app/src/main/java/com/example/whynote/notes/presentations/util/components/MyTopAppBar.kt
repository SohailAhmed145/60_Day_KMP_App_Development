package com.example.whynote.notes.presentations.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.whynote.R
import com.example.whynote.notes.data.room.NoteViewModel
import com.example.whynote.notes.presentations.navigation_drawer.NavigationDrawer
import kotlinx.coroutines.launch


@Composable
fun MyTopAppBar(drawerState: DrawerState){

    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier.padding(top = 10.dp, start = 15.dp, end = 15.dp, bottom = 10.dp),
        shape = RoundedCornerShape(35.dp),
    ) {
        Row (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .fillMaxWidth()
                .height(45.dp)
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ){
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(
                    painter = painterResource(R.drawable.menu) ,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                )
            }

            TextField(
                modifier = Modifier
                    .width(180.dp)
                    .wrapContentHeight(Alignment.CenterVertically, true),
                value = "",
                placeholder = {
                              Text(text = "Search your notes", color = MaterialTheme.colorScheme.primary)
                },
                onValueChange = {},
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                ),
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.grid_view),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.account_circle),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}