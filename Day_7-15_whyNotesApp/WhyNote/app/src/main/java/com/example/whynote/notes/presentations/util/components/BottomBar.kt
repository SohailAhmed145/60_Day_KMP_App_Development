package com.example.whynote.notes.presentations.util.components




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whynote.R
import com.example.whynote.notes.presentations.notes_screen.Destination
import com.example.whynote.notes.presentations.notes_screen.components.Fab


@Composable
fun BottomBar(navController: NavController) {
    Column (
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
      
        Fab(navController = navController)

        Box (
            modifier = Modifier
                .width(200.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer),
        ){
           Row (
               modifier = Modifier
                   .height(50.dp)
                   .fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceEvenly,
               verticalAlignment = Alignment.CenterVertically
           ){
               IconButton(onClick = { /* do something */ }) {
                   Icon(
                       Icons.Outlined.Check,
                       contentDescription = "make list",
                       modifier = Modifier.size(30.dp),
                       tint = MaterialTheme.colorScheme.primary
                   )

               }
               IconButton(onClick = { /* do something */ }) {
                   Icon(
                       painter = painterResource(R.drawable.brush),
                       contentDescription = "draw a note",
                       modifier = Modifier.size(30.dp),
                       tint = MaterialTheme.colorScheme.primary
                   )
               }

               IconButton(onClick = { /* do something */ }) {
                   Icon(
                       painter = painterResource(R.drawable.image),
                       tint = MaterialTheme.colorScheme.primary,
                       contentDescription = "profile picture",
                       modifier = Modifier.size(30.dp),
                   )
               }

           }
        }


    }
}



