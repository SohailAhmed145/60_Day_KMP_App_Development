package com.example.whynote.notes.presentations.navigation_drawer


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.whynote.MyApplication
import com.example.whynote.R
import com.example.whynote.notes.data.room.NoteViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationDrawer(viewModel: NoteViewModel, navController: NavHostController){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val items = listOf(
        DrawerItem(
            label = "Notes",
            icon = painterResource(id = R.drawable.note),
            secondaryLabel = "1"
        ) ,
        DrawerItem(
            label = "Reminders",
            icon = painterResource(id = R.drawable.reminders),
            secondaryLabel = "2"
        ) ,

        DrawerItem(
            label = "Create new label",
            icon = painterResource(id = R.drawable.newlabel),
            secondaryLabel = "3"
        ),
        DrawerItem(
            label = "Archive",
            icon = painterResource(id = R.drawable.archive),
            secondaryLabel = "4"
        ),
        DrawerItem(
            label = "Trash",
            icon = painterResource(id = R.drawable.trash),
            secondaryLabel = "5"
        ),
        DrawerItem(
            label = "Settings",
            icon = painterResource(id = R.drawable.settings),
            secondaryLabel = "4"
        ),
        DrawerItem(
            label = "Help & feedback",
            icon = painterResource(id = R.drawable.help),
            secondaryLabel = "5"
        )
    )
    var selectedItem by remember{
        mutableStateOf(items[0])
    }


    ModalNavigationDrawer(
        drawerState = drawerState,
        scrimColor =  MaterialTheme.colorScheme.scrim,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet (
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                drawerContainerColor = MaterialTheme.colorScheme.onPrimary,
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
                        modifier = Modifier.padding(horizontal = 15.dp),
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MaterialTheme.colorScheme.onPrimary,
                            selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer
                        ),
                        icon = { Icon(painter = item.icon, contentDescription = item.label) },
                        label = { Text(text = item.label) },
                        selected = item == selectedItem,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            selectedItem = item
                            when(item.label){
                                "Notes" -> navController.navigate("NoteScreen")
                            }
                        },

                    )

                }
            }
        },

    ){

        MyApplication(myViewModel = viewModel, navController , drawerState)


    }

}

data class DrawerItem(
    val label: String,
    val icon: Painter,
    val secondaryLabel: String
)
