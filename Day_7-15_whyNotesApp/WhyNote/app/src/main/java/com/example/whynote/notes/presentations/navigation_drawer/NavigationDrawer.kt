package com.example.whynote.notes.presentations.navigation_drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer(){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val items = listOf(
        DrawerItem(
            label = "Home", icon = Icons.Filled.Home, secondaryLabel = "1"
        ) ,
        DrawerItem(
            label = "Home", icon = Icons.Filled.Notifications, secondaryLabel = "2"
        ) ,

        DrawerItem(
            label = "messages", icon = Icons.Filled.Add, secondaryLabel = "3"
        ),
        DrawerItem(
            label = "mail", icon = Icons.Filled.Favorite, secondaryLabel = "4"
        ),
        DrawerItem(
            label = "settings", icon = Icons.Filled.Settings, secondaryLabel = "5"
        ),
        DrawerItem(
            label = "mail", icon = Icons.Filled.Favorite, secondaryLabel = "4"
        ),
        DrawerItem(
            label = "settings", icon = Icons.Filled.Share, secondaryLabel = "5"
        )
    )
    var selectedItem by remember{
        mutableStateOf(items[0])
    }


    ModalNavigationDrawer(
        drawerState = drawerState,
        scrimColor =  Color.Gray,
        drawerContent = {
            ModalDrawerSheet (
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .background(MaterialTheme.colorScheme.onPrimary)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, top = 1.dp, bottom = 15.dp),
                    contentAlignment = Alignment.TopStart
                ){
                    Text(text = "Header", style = MaterialTheme.typography.headlineLarge)
                }
                items.forEach { item ->

                    NavigationDrawerItem(
                        icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                        label = { Text(text = item.label) },
                        selected = item == selectedItem,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                                  selectedItem = item
                                  },

                    )

                }
            }
        },
       content = {
           Content(
               onClick = { scope.launch {
                   drawerState.open()
                 }
               }
           )

       }
    )

}

data class DrawerItem(
    val label: String,
    val icon: ImageVector,
    val secondaryLabel: String
)

@Composable
fun Content(
    onClick: () -> Unit
){
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = ">> swipe >>")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "click to open")
        }
    }
}